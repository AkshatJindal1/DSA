package leetcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class GraphPlotter extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int BORDER_GAP = 30;
    private static final Color GRAPH_COLOR = Color.green;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final Stroke GRAPH_STROKE = new BasicStroke(1f);
    private static final int GRAPH_POINT_WIDTH = 0;
    private static final int Y_HATCH_CNT = 10;
    private final List<Long> abscissa;
    private final List<Long> ordinate;

    public GraphPlotter(List<Long> abscissa, List<Long> ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (Collections.max(abscissa) - Collections.min(abscissa));
        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (Collections.max(ordinate) - Collections.min(ordinate));

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < abscissa.size(); i++) {
            int x1 = (int) ((ordinate.get(i) - Collections.min(ordinate)) * xScale + BORDER_GAP);
            int y1 = (int) ((Collections.max(abscissa) - abscissa.get(i)) * yScale + BORDER_GAP);
            System.out.println(x1 + " " + y1 + " " + ordinate.get(i) + " " + abscissa.get(i));
//            int x1 = (int) (i * xScale + BORDER_GAP);
//            int y1 = (int) ((MAX_SCORE - absicca.get(i)) * yScale + BORDER_GAP);
            graphPoints.add(new Point(x1, y1));
        }

        // create x and y axes
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

        // create hatch marks for y axis.
        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = 0; i < ordinate.size() - 1; i++) {
            int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (ordinate.size() - 1) + BORDER_GAP;
            int x1 = x0;
            int y0 = getHeight() - BORDER_GAP;
            int y1 = y0 - GRAPH_POINT_WIDTH;
            g2.drawLine(x0, y0, x1, y1);
        }

        Stroke oldStroke = g2.getStroke();
        g2.setColor(GRAPH_COLOR);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }

        g2.setStroke(oldStroke);
        g2.setColor(GRAPH_POINT_COLOR);
        for (Point graphPoint : graphPoints) {
            int x = graphPoint.x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoint.y - GRAPH_POINT_WIDTH / 2;
            ;
            int ovalW = GRAPH_POINT_WIDTH;
            int ovalH = GRAPH_POINT_WIDTH;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        List<Long> scores = new ArrayList<>();
        List<Long> xs = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 16;
        int maxScore = 20;
        for (int i = 0; i < maxDataPoints ; i++) {
            scores.add(ThreadLocalRandom.current().nextLong(10000L));
            xs.add((long)i);
        }
        GraphPlotter mainPanel = new GraphPlotter(scores, xs);

        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void printGraph(List<Long> abscissa, List<Long> ordinate) {
        GraphPlotter mainPanel = new GraphPlotter(abscissa, ordinate);
        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphPlotter::createAndShowGui);

    }
}

package org.cyrano.masscenter.test1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.cyrano.boxcollision.base.Box;
import org.cyrano.masscenter.MassCenterCalculator;
import org.cyrano.util.misc.Hwh;

/**
 * @author Demián Gutierrez
 */
public class GamePanel extends JPanel {

  private List<Box> boxList = new ArrayList<Box>();

  private BoxImpl dragBox;

  private int dx;
  private int dy;

  // --------------------------------------------------------------------------------

  public GamePanel() {
    BoxImpl box1 = new BoxImpl();

    box1.cx = 100;
    box1.cy = 300;
    box1.bw = 75;
    box1.bh = 50;

    boxList.add(box1);

    // ----------------------------------------

    BoxImpl box2 = new BoxImpl();

    box2.cx = 110;
    box2.cy = 100;
    box2.bw = 50;
    box2.bh = 75;

    boxList.add(box2);

    // ----------------------------------------

    box2 = new BoxImpl();

    box2.cx = 200;
    box2.cy = 300;
    box2.bw = 50;
    box2.bh = 50;

    boxList.add(box2);

    // ----------------------------------------

    box2 = new BoxImpl();

    box2.cx = 500;
    box2.cy = 400;
    box2.bw = 10;
    box2.bh = 100;

    boxList.add(box2);

    // ----------------------------------------

    box2 = new BoxImpl();

    box2.cx = 100;
    box2.cy = 300;
    box2.bw = 40;
    box2.bh = 60;

    boxList.add(box2);

    // ----------------------------------------

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed/* */(MouseEvent evt) {
        GamePanel.this.mousePressed/* */(evt);
      }

      @Override
      public void mouseReleased/**/(MouseEvent evt) {
        GamePanel.this.mouseReleased/**/(evt);
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged/* */(MouseEvent evt) {
        GamePanel.this.mouseDragged/* */(evt);
      }
    });
  }

  // --------------------------------------------------------------------------------

  //  public void setGrayTimeFactor(double grayTimeFactor) {
  //    this.grayTimeFactor = grayTimeFactor;
  //
  //    repaint();
  //  }

  // --------------------------------------------------------------------------------

  private void drawBox(Graphics2D g2d, BoxImpl box, Color color) {

    //    g2d.setColor(Color.CYAN);
    //    g2d.drawRect((int) box.sx, (int) box.sy, (int) box.bw, (int) box.bh);

    g2d.setColor(color);
    g2d.drawRect((int) box.cx, (int) box.cy, (int) box.bw, (int) box.bh);

    //    Point beg1 = new Point();
    //    Point end1 = new Point();
    //    Point beg2 = new Point();
    //    Point end2 = new Point();
    //
    //    if (box.cx < box.sx) {
    //      if (box.cy < box.sy) {
    //        beg1.setLocation(box.cx, box.cy + box.bh);
    //        end1.setLocation(box.sx, box.sy + box.bh);
    //
    //        beg2.setLocation(box.cx + box.bw, box.cy);
    //        end2.setLocation(box.sx + box.bw, box.sy);
    //      } else if (box.cy == box.sy) {
    //        beg1.setLocation(box.cx + box.bw, box.cy + box.bh);
    //        end1.setLocation(box.sx, box.sy + box.bh);
    //
    //        beg2.setLocation(box.cx + box.bw, box.cy);
    //        end2.setLocation(box.sx, box.sy);
    //      } else {
    //        beg1.setLocation(box.cx + box.bw, box.cy + box.bh);
    //        end1.setLocation(box.sx + box.bw, box.sy + box.bh);
    //
    //        beg2.setLocation(box.cx, box.cy);
    //        end2.setLocation(box.sx, box.sy);
    //      }
    //      // -------------------------------------------
    //    } else if (box.cx == box.sx) {
    //      if (box.cy < box.sy) {
    //        beg1.setLocation(box.cx, box.cy + box.bh);
    //        end1.setLocation(box.sx, box.sy);
    //
    //        beg2.setLocation(box.cx + box.bw, box.cy + box.bh);
    //        end2.setLocation(box.sx + box.bw, box.sy);
    //      } else if (box.cy == box.sy) {
    //        // NONE
    //      } else {
    //        beg1.setLocation(box.sx, box.sy + box.bh);
    //        end1.setLocation(box.cx, box.cy);
    //
    //        beg2.setLocation(box.sx + box.bw, box.sy + box.bh);
    //        end2.setLocation(box.cx + box.bw, box.cy);
    //      }
    //      // -------------------------------------------
    //    } else {
    //      if (box.cy < box.sy) {
    //        beg1.setLocation(box.sx, box.sy);
    //        end1.setLocation(box.cx, box.cy);
    //
    //        beg2.setLocation(box.sx + box.bw, box.sy + box.bh);
    //        end2.setLocation(box.cx + box.bw, box.cy + box.bh);
    //      } else if (box.cy == box.sy) {
    //        beg1.setLocation(box.sx + box.bw, box.sy);
    //        end1.setLocation(box.cx, box.cy);
    //
    //        beg2.setLocation(box.sx + box.bw, box.sy + box.bh);
    //        end2.setLocation(box.cx, box.cy + box.bh);
    //      } else {
    //        beg1.setLocation(box.cx + box.bw, box.cy);
    //        end1.setLocation(box.sx + box.bw, box.sy);
    //
    //        beg2.setLocation(box.cx, box.cy + box.bh);
    //        end2.setLocation(box.sx, box.sy + box.bh);
    //      }
    //    }
    //
    //    if (beg1 != null && end1 != null) {
    //      g2d.setColor(Color.WHITE);
    //      g2d.drawLine(beg1.x, beg1.y, end1.x, end1.y);
    //    }
    //    if (beg2 != null && end2 != null) {
    //      g2d.setColor(Color.WHITE);
    //      g2d.drawLine(beg2.x, beg2.y, end2.x, end2.y);
    //    }
  }

  // --------------------------------------------------------------------------------

  //  private void drawBox(Graphics2D g2d, BoxImpl box, Color color, CollisionInfo ci) {
  //    int x, y, w, h;
  //
  //    if (ci.time != Double.MAX_VALUE) {
  //      x = (int) (box.cx + box.vx * ci.time * grayTimeFactor);
  //      y = (int) (box.cy + box.vy * ci.time * grayTimeFactor);
  //    } else {
  //      x = (int) (box.cx + box.vx * 1 * grayTimeFactor);
  //      y = (int) (box.cy + box.vy * 1 * grayTimeFactor);
  //    }
  //
  //    w = box.bw;
  //    h = box.bh;
  //
  //    g2d.setColor(Color.GRAY);
  //    g2d.drawRect(x, y, w, h);
  //
  //    x = (int) (box.cx + box.vx * ci.time);
  //    y = (int) (box.cy + box.vy * ci.time);
  //    w = box.bw;
  //    h = box.bh;
  //
  //    g2d.setColor(color);
  //    g2d.drawRect(x, y, w, h);
  //
  //    Side side = null;
  //
  //    if (box == ci.box1) {
  //      side = ci.box1Side;
  //    }
  //
  //    if (box == ci.box2) {
  //      side = ci.box2Side;
  //    }
  //
  //    if (side != null) {
  //      g2d.setColor(Color.WHITE);
  //
  //      switch (side) {
  //        case LFT :
  //          g2d.drawLine(x,/* */y,/* */x,/* */y + h);
  //          break;
  //
  //        case RGH :
  //          g2d.drawLine(x + w, y,/* */x + w, y + h);
  //          break;
  //
  //        case TOP :
  //          g2d.drawLine(x,/* */y,/* */x + w, y/**/);
  //          break;
  //
  //        case BOT :
  //          g2d.drawLine(x,/* */y + h, x + w, y + h);
  //          break;
  //      }
  //    }
  //  }

  // --------------------------------------------------------------------------------
  // JPanel
  // --------------------------------------------------------------------------------

  @Override
  public void paint(Graphics g) {
    update(g);
  }

  @Override
  public void update(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    g2d.setBackground(Color.BLACK);
    g2d.clearRect(0, 0, Hwh.getW(this), Hwh.getH(this));

    //    CollisionInfo ci = new CollisionInfo(box1, box2);
    //    CollisionDetector.calcTimeToCollide(ci);

    Point p1 = MassCenterCalculator.calcMassCenter(boxList, true);

    g2d.setColor(Color.YELLOW);
    g2d.fillRect(p1.x - 5, p1.y - 5, 10, 10);

    Point p2 = MassCenterCalculator.calcMassCenter(boxList, false);

    g2d.setColor(Color.CYAN);
    g2d.drawLine(p2.x - 10, p2.y, p2.x + 10, p2.y);
    g2d.drawLine(p2.x, p2.y - 10, p2.x, p2.y + 10);

    for (Box box1 : boxList) {
      drawBox(g2d, (BoxImpl) box1, Color.RED);
    }

    //    drawBox(g2d, box1, BOX1_COLOR, ci);
    //    drawBox(g2d, box2, BOX2_COLOR, ci);
  }

  // --------------------------------------------------------------------------------
  // Mouse handling
  // --------------------------------------------------------------------------------

  private void mousePressed(MouseEvent evt) {
    for (Box box : boxList) {
      Rectangle r;

      r = new Rectangle(box.minX(), box.minY(), box.getW(), box.getH());

      if (r.contains(evt.getPoint())) {
        dx = evt.getPoint().x - box.minX();
        dy = evt.getPoint().y - box.minY();
        dragBox = (BoxImpl) box;
        return;
      }

      //      r = new Rectangle(box.sx, box.sy, box.bw, box.bh);
      //
      //      if (r.contains(evt.getPoint())) {
      //        dx = evt.getPoint().x - box.sx;
      //        dy = evt.getPoint().y - box.sy;
      //        dragBox = box;
      //        start = false;
      //        return;
      //      }
    }
  }

  // --------------------------------------------------------------------------------

  private void mouseReleased(MouseEvent e) {
    dragBox = null;
  }

  // --------------------------------------------------------------------------------

  private void mouseDragged(MouseEvent evt) {
    if (dragBox == null) {
      return;
    }

    //    if (start) {
    dragBox.cx = evt.getPoint().x - dx;
    dragBox.cy = evt.getPoint().y - dy;
    //    } else {
    //      dragBox.sx = evt.getPoint().x - dx;
    //      dragBox.sy = evt.getPoint().y - dy;
    //    }

    //    dragBox.calcV();

    repaint();
  }
}

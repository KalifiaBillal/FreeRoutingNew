/*
 *  Copyright (C) 2014  Alfons Wirtz  
 *   website www.freerouting.net
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License at <http://www.gnu.org/licenses/> 
 *   for more details.
 *
 * PopupMenuMove.java
 *
 * Created on 15. Mai 2005, 11:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package gui.menu;

import freert.main.Stat;
import gui.BoardFrame;
import gui.varie.GuiResources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Alfons Wirtz
 */
public class PopupMenuMove extends PopupMenuDisplay
   {
   private static final long serialVersionUID = 1L;

   public PopupMenuMove(Stat stat, BoardFrame p_board_frame)
      {
      super(stat, p_board_frame);
      
      GuiResources resources = p_board_frame.newGuiResources("gui.resources.PopupMenuMove");

      // Add menu for turning the items by a multiple of 90 degree

      JMenuItem rotate_menu = new JMenu();
      rotate_menu.setText(resources.getString("turn"));
      this.add(rotate_menu, 0);

      JMenuItem turn_90_item = new JMenuItem();
      turn_90_item.setText(resources.getString("90_degree"));
      turn_90_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(2);
               }
         });
      rotate_menu.add(turn_90_item);

      JMenuItem turn_180_item = new JMenuItem();
      turn_180_item.setText(resources.getString("180_degree"));
      turn_180_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(4);
               }
         });
      rotate_menu.add(turn_180_item);

      JMenuItem turn_270_item = new JMenuItem();
      turn_270_item.setText(resources.getString("-90_degree"));
      turn_270_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(6);
               }
         });
      rotate_menu.add(turn_270_item);

      JMenuItem turn_45_item = new JMenuItem();
      turn_45_item.setText(resources.getString("45_degree"));
      turn_45_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(1);
               }
         });
      rotate_menu.add(turn_45_item);

      JMenuItem turn_135_item = new JMenuItem();
      turn_135_item.setText(resources.getString("135_degree"));
      turn_135_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(3);
               }
         });
      rotate_menu.add(turn_135_item);

      JMenuItem turn_225_item = new JMenuItem();
      turn_225_item.setText(resources.getString("-135_degree"));
      turn_225_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(5);
               }
         });
      rotate_menu.add(turn_225_item);

      JMenuItem turn_315_item = new JMenuItem();
      turn_315_item.setText(resources.getString("-45_degree"));
      turn_315_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               rotate_45_deg(7);
               }
         });
      rotate_menu.add(turn_315_item);

      JMenuItem change_side_item = new JMenuItem();
      change_side_item.setText(resources.getString("change_side"));
      change_side_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               board_panel.itera_board.change_placement_side();
               }
         });

      this.add(change_side_item, 1);

      JMenuItem reset_rotation_item = new JMenuItem();
      reset_rotation_item.setText(resources.getString("reset_rotation"));
      reset_rotation_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               interactive.state.StateInteractive interactive_state = board_panel.itera_board.get_interactive_state();
               if (interactive_state instanceof interactive.state.StateMoveItem)
                  {
                  ((interactive.state.StateMoveItem) interactive_state).reset_rotation();
                  }
               }
         });

      this.add(reset_rotation_item, 2);

      JMenuItem insert_item = new JMenuItem();
      insert_item.setText(resources.getString("insert"));
      insert_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               board_panel.itera_board.return_from_state();
               }
         });

      this.add(insert_item, 3);

      JMenuItem cancel_item = new JMenuItem();
      cancel_item.setText(resources.getString("cancel"));
      cancel_item.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
               {
               board_panel.itera_board.cancel_state();
               }
         });

      this.add(cancel_item, 4);
      }

   private void rotate_45_deg(int p_factor)
      {
      board_panel.itera_board.rotate_45_deg(p_factor);
      board_panel.move_mouse(board_panel.right_button_click_location);
      }
   }

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
 * Placement.java
 *
 * Created on 5. Juli 2004, 08:53
 */

package specctra;

/**
 * Class for writing placement scopes from dsn-files.
 *
 * @author Alfons Wirtz
 */
public class DsnKeywordPlacement extends DsnKeywordScope
   {

   public DsnKeywordPlacement()
      {
      super("placement");
      }

   public static void write_scope(DsnWriteScopeParameter p_par) throws java.io.IOException
      {
      p_par.file.start_scope();
      p_par.file.write("placement");
      if (p_par.board.brd_components.get_flip_style_rotate_first())
         {
         p_par.file.new_line();
         p_par.file.write("(place_control (flip_style rotate_first))");
         }
      for (int i = 1; i <= p_par.board.library.packages.pkg_count(); ++i)
         {
         DsnKeywordPackage.write_placement_scope(p_par, p_par.board.library.packages.pkg_get(i));
         }
      p_par.file.end_scope();
      }
   }

// $Id$

package prefobj;

import java.awt.*;
import java.util.prefs.*;

public class GetSettings
{
  static public void main( String args[] ) throws Exception {
    java.lang.Class clazz = GetSettings.class;
    Preferences prefs = Preferences.userNodeForPackage( clazz );

    Font font = (Font)PrefObj.getObject( prefs, "font" );
    Color color = (Color)PrefObj.getObject( prefs, "color" );

    System.out.println( "Read "+font );
    System.out.println( "Read "+color );
  }
}

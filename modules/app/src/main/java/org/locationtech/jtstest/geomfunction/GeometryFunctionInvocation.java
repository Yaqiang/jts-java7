/*
 * Copyright (c) 2016 Vivid Solutions.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.locationtech.jtstest.geomfunction;

import org.locationtech.jts.geom.Geometry;

public class GeometryFunctionInvocation {

  private GeometryFunction function;
  private Object[] args;

  public GeometryFunctionInvocation(GeometryFunction function, Object[] args) {
    this.function = function;
    this.args = args;
  }

  public String getSignature() {
    if (function == null)
      return null;
    return function.getCategory() 
        + "." + function.getName()
        + "(" + toString(args) + ")";
  }

  public GeometryFunction getFunction() {
    return function;
  }

  public Object[] getArgs() {
    return args;
  }
  
  public static String toString(Object[] param)
  {
    if (param == null) return "";
    
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < param.length; i++) {
      if (i > 0) buf.append(", ");
      buf.append(toString(param[i]));
    }
    return buf.toString();
  }

  public static String toString(Object o)
  {
    if (o == null) return "null";
    if (o instanceof Geometry)
      return ((Geometry) o).getGeometryType();
    return o.toString();
  }
}

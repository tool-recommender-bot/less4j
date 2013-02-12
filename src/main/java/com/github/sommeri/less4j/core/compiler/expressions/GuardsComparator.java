package com.github.sommeri.less4j.core.compiler.expressions;

import com.github.sommeri.less4j.core.ast.NumberExpression;
import com.github.sommeri.less4j.core.ast.NumberExpression.Dimension;

public class GuardsComparator extends ExpressionComparator {

  @Override
  protected boolean numberEqual(NumberExpression pattern, NumberExpression numberExpression) {
    if (!canCompareDimensions(pattern.getDimension(), numberExpression.getDimension()))
      return false;

    return equals(pattern.getValueAsDouble(), numberExpression.getValueAsDouble());
  }

  private boolean canCompareDimensions(Dimension left, Dimension right) {
    if (right==Dimension.NUMBER || left==Dimension.NUMBER)
      return true;
    
    return left.equals(right);
  }

}

package com.github.sommeri.less4j.core.compiler.scopes;

import java.util.List;

import com.github.sommeri.less4j.core.ast.ASTCssNode;
import com.github.sommeri.less4j.core.ast.AbstractVariableDeclaration;
import com.github.sommeri.less4j.core.ast.Expression;
import com.github.sommeri.less4j.core.ast.ReusableStructure;
import com.github.sommeri.less4j.core.ast.ReusableStructureName;
import com.github.sommeri.less4j.core.ast.Variable;
import com.github.sommeri.less4j.core.compiler.expressions.ExpressionFilter;

public class ScopeDecorator extends Scope {

  private static final String DECORATOR = "#decorator#";
  private final Scope decoree;  
  
  //FIXME: (!!!) do correctly
  protected ScopeDecorator(Scope decoree) {
    super(DECORATOR, null, decoree.toFullName());
    this.decoree = decoree;
  }

  public void addNames(List<String> names) {
    decoree.addNames(names);
  }

  public List<Scope> getChilds() {
    return decoree.getChilds();
  }

  public List<String> getNames() {
    return decoree.getNames();
  }

  public void fillByFilteredVariables(ExpressionFilter filter, Scope source) {
    decoree.fillByFilteredVariables(filter, source);
  }

  public void addAllMixins(List<FullMixinDefinition> mixins) {
    decoree.addAllMixins(mixins);
  }

  public void add(Scope otherSope) {
    decoree.add(otherSope);
  }

  public void addVariables(Scope otherSope) {
    decoree.addVariables(otherSope);
  }

  public void createPlaceholder() {
    decoree.createPlaceholder();
  }

  public void addToPlaceholder(Scope otherScope) {
    decoree.addToPlaceholder(otherScope);
  }

  public void closePlaceholder() {
    decoree.closePlaceholder();
  }

  public List<FullMixinDefinition> getAllMixins() {
    return decoree.getAllMixins();
  }

  public List<FullMixinDefinition> getMixinsByName(List<String> nameChain, ReusableStructureName name) {
    return decoree.getMixinsByName(nameChain, name);
  }

  public List<FullMixinDefinition> getMixinsByName(ReusableStructureName name) {
    return decoree.getMixinsByName(name);
  }

  public List<FullMixinDefinition> getMixinsByName(String name) {
    return decoree.getMixinsByName(name);
  }

  public Scope firstChild() {
    return decoree.firstChild();
  }

  public Scope getChildOwnerOf(ASTCssNode body) {
    return decoree.getChildOwnerOf(body);
  }

  public Scope childByOwners(ASTCssNode headNode, ASTCssNode... restNodes) {
    return decoree.childByOwners(headNode, restNodes);
  }

  public void addRequestCollector(RequestCollector requestCollector) {
    decoree.addRequestCollector(requestCollector);
  }

  public boolean equals(Object obj) {
    return decoree.equals(obj);
  }

  public Scope getParent() {
    return decoree.getParent();
  }

  public boolean hasParent() {
    return decoree.hasParent();
  }

  public String toFullName() {
    return decoree.toFullName();
  }

  public void registerVariable(AbstractVariableDeclaration declaration) {
    decoree.registerVariable(declaration);
  }

  public void registerVariable(AbstractVariableDeclaration node, Expression replacementValue) {
    decoree.registerVariable(node, replacementValue);
  }

  public void registerVariableIfNotPresent(String name, Expression replacementValue) {
    decoree.registerVariableIfNotPresent(name, replacementValue);
  }

  public void registerVariable(String name, Expression replacementValue) {
    decoree.registerVariable(name, replacementValue);
  }

  public Expression getValue(Variable variable) {
    return decoree.getValue(variable);
  }

  public Expression getValue(String name) {
    return decoree.getValue(name);
  }

  public Expression getLocalValue(Variable variable) {
    return decoree.getLocalValue(variable);
  }

  public Expression getLocalValue(String name) {
    return decoree.getLocalValue(name);
  }

  public Expression getVariableValueDoNotRegister(String name) {
    return decoree.getVariableValueDoNotRegister(name);
  }

  public void registerMixin(ReusableStructure mixin, Scope mixinsBodyScope) {
    decoree.registerMixin(mixin, mixinsBodyScope);
  }

  public boolean isBodyOwnerScope() {
    return decoree.isBodyOwnerScope();
  }

  public Scope skipBodyOwner() {
    return decoree.skipBodyOwner();
  }

  public String toLongString() {
    return decoree.toLongString();
  }

  public void setParent(Scope parent) {
    //FIXME: (!!!) following check is needed due to constructor call in Scope - needs clean up after we know things really got faster
    if (decoree!=null)
      decoree.setParent(parent);
  }

  public void removedFromTree() {
    decoree.removedFromTree();
  }

  public boolean isPresentInTree() {
    return decoree.isPresentInTree();
  }

  public Scope getRootScope() {
    return decoree.getRootScope();
  }

  public boolean seesLocalDataOf(Scope otherScope) {
    return decoree.seesLocalDataOf(otherScope);
  }

  public void removeRequestCollector(RequestCollector requestCollector) {
    decoree.removeRequestCollector(requestCollector);
  }

  public int getTreeSize() {
    return decoree.getTreeSize();
  }

  public int hashCode() {
    return decoree.hashCode();
  }

  @Override
  public boolean hasTheSameLocalData(LocalScope otherScope) {
    return decoree.hasTheSameLocalData(otherScope);
  }

  @Override
  protected void createLocalDataSnapshot() {
    decoree.createLocalDataSnapshot();
  }

  @Override
  protected void discardLastLocalDataSnapshot() {
    decoree.discardLastLocalDataSnapshot();
  }

  @Override
  protected void registerVariableRequest(String name, Expression value) {
    decoree.registerVariableRequest(name, value);
  }

  @Override
  protected VariablesDeclarationsStorage getLocalVariables() {
    return decoree.getLocalVariables();
  }

  protected LocalScopeData getLocalData() {
    return decoree.getLocalData();
  }
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(toFullName());
    result.append("\n\n").append(decoree.toString());
    return result.toString();
  }

}

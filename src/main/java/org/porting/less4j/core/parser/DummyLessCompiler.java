package org.porting.less4j.core.parser;

import org.porting.less4j.ILessCompiler;

public class DummyLessCompiler implements ILessCompiler {

	public String compile(String cssContent) {
		return cssContent;
	}

}

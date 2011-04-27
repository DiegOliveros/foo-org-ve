/*
 * Created on 04/02/2008
 */
package com.minotauro.state.demo.workflow;

import com.minotauro.state.generator.BaseSMMain;

/**
 * @author Demián Gutierrez
 */
public class Main extends BaseSMMain {

  public Main(String template) {
    super(template);
  }

  public static void main(String[] args) throws Exception {
    Main m = new Main("class-state-wf.ftl");

    m.stateMachine("workflow");
  }
}

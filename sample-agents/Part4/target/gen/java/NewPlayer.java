/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.core.*;
import astra.execution.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.reasoner.util.*;

import mams.web.HttpResponse;
import mams.JSONConverter;
import mams.JSONBuilder;
import astra.jena.*;
import com.fasterxml.jackson.databind.JsonNode;

public class NewPlayer extends ASTRAClass {
	public NewPlayer() {
		setParents(new Class[] {Player.class});
		addRule(new Rule(
			"NewPlayer", new int[] {27,8,27,107},
			new GoalEvent('+',
				new Goal(
					new Predicate("handle_move", new Term[] {
						new Variable(Type.STRING, "form_url",false),
						new Variable(Type.STRING, "method",false),
						new Variable(Type.STRING, "id",false)
					})
				)
			),
			new Predicate("game", new Term[] {
				new Variable(Type.STRING, "id"),
				new Variable(Type.STRING, "role",false),
				new Variable(Type.STRING, "opponent",false)
			}),
			new Block(
				"NewPlayer", new int[] {27,106,79,4},
				new Statement[] {
					new ForEach(
						"NewPlayer", new int[] {29,7,79,4},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "square",false),
							new Variable(Type.STRING, "player",false)
						}),
						new Block(
							"NewPlayer", new int[] {29,51,33,8},
							new Statement[] {
								new If(
									"NewPlayer", new int[] {30,11,33,8},
									new NOT(
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "player"),
												new Variable(Type.STRING, "role")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("NewPlayer","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											)
									),
									new Block(
										"NewPlayer", new int[] {30,44,32,12},
										new Statement[] {
											new BeliefUpdate('+',
												"NewPlayer", new int[] {31,15,32,12},
												new Predicate("opponent_last_move", new Term[] {
													new Variable(Type.STRING, "square")
												})
											)
										}
									)
								)
							}
						)
					),
					new If(
						"NewPlayer", new int[] {36,7,79,4},
						new Predicate("opponent_last_move", new Term[] {
							new Variable(Type.STRING, "opp_square",false)
						}),
						new Block(
							"NewPlayer", new int[] {36,49,53,8},
							new Statement[] {
								new If(
									"NewPlayer", new int[] {38,11,53,8},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "opp_square"),
											Primitive.newPrimitive("22")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("NewPlayer","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"NewPlayer", new int[] {38,47,44,12},
										new Statement[] {
											new If(
												"NewPlayer", new int[] {39,15,44,12},
												new Predicate("free", new Term[] {
													Primitive.newPrimitive("11")
												}),
												new Block(
													"NewPlayer", new int[] {39,30,41,16},
													new Statement[] {
														new BeliefUpdate('+',
															"NewPlayer", new int[] {40,19,41,16},
															new Predicate("last_move", new Term[] {
																Primitive.newPrimitive("11")
															})
														)
													}
												),
												new If(
													"NewPlayer", new int[] {41,22,44,12},
													new Predicate("free", new Term[] {
														Primitive.newPrimitive("33")
													}),
													new Block(
														"NewPlayer", new int[] {41,37,43,16},
														new Statement[] {
															new BeliefUpdate('+',
																"NewPlayer", new int[] {42,19,43,16},
																new Predicate("last_move", new Term[] {
																	Primitive.newPrimitive("33")
																})
															)
														}
													)
												)
											)
										}
									),
									new If(
										"NewPlayer", new int[] {46,16,53,8},
										new AND(
											new Predicate("corner_map", new Term[] {
												new Variable(Type.STRING, "opp_square"),
												new Variable(Type.STRING, "mirror_square",false)
											}),
											new Predicate("free", new Term[] {
												new Variable(Type.STRING, "mirror_square")
											})
										),
										new Block(
											"NewPlayer", new int[] {46,87,48,12},
											new Statement[] {
												new BeliefUpdate('+',
													"NewPlayer", new int[] {47,15,48,12},
													new Predicate("last_move", new Term[] {
														new Variable(Type.STRING, "mirror_square")
													})
												)
											}
										),
										new If(
											"NewPlayer", new int[] {50,17,53,8},
											new AND(
												new Predicate("edge_map", new Term[] {
													new Variable(Type.STRING, "opp_square"),
													new Variable(Type.STRING, "mirror_square")
												}),
												new Predicate("free", new Term[] {
													new Variable(Type.STRING, "mirror_square")
												})
											),
											new Block(
												"NewPlayer", new int[] {50,80,52,12},
												new Statement[] {
													new BeliefUpdate('+',
														"NewPlayer", new int[] {51,15,52,12},
														new Predicate("last_move", new Term[] {
															new Variable(Type.STRING, "mirror_square")
														})
													)
												}
											)
										)
									)
								)
							}
						)
					),
					new If(
						"NewPlayer", new int[] {56,7,79,4},
						new NOT(
							new Predicate("last_move", new Term[] {
								new Variable(Type.STRING, "anyMove",false)
							})
						),
						new Block(
							"NewPlayer", new int[] {56,38,62,8},
							new Statement[] {
								new If(
									"NewPlayer", new int[] {57,11,62,8},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("22")
									}),
									new Block(
										"NewPlayer", new int[] {57,26,59,12},
										new Statement[] {
											new BeliefUpdate('+',
												"NewPlayer", new int[] {58,15,59,12},
												new Predicate("last_move", new Term[] {
													Primitive.newPrimitive("22")
												})
											)
										}
									),
									new Block(
										"NewPlayer", new int[] {59,18,62,8},
										new Statement[] {
											new Subgoal(
												"NewPlayer", new int[] {60,15,61,12},
												new Goal(
													new Predicate("take_any_free", new Term[] {})
												)
											)
										}
									)
								)
							}
						)
					),
					new If(
						"NewPlayer", new int[] {64,7,79,4},
						new Predicate("last_move", new Term[] {
							new Variable(Type.STRING, "chosen_square",false)
						}),
						new Block(
							"NewPlayer", new int[] {64,43,78,8},
							new Statement[] {
								new ModuleCall("console",
									"NewPlayer", new int[] {65,11,65,76},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Making mirror move to square: "),
											new Variable(Type.STRING, "chosen_square")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("NewPlayer","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"NewPlayer", new int[] {66,11,78,8},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("NewPlayer","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("NewPlayer","builder")).createObject(
												);
											}
										}
									)
								),
								new Query(
									"NewPlayer", new int[] {67,11,67,58},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "agentURL",false)
									})
								),
								new ModuleCall("builder",
									"NewPlayer", new int[] {68,11,68,57},
									new Predicate("addProperty", new Term[] {
										new Variable(new ObjectType(JsonNode.class), "bodyJson"),
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "agentURL")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((mams.JSONBuilder) intention.getModule("NewPlayer","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"NewPlayer", new int[] {69,11,78,8},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("NewPlayer","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("NewPlayer","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new If(
									"NewPlayer", new int[] {71,11,78,8},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("NewPlayer","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"NewPlayer", new int[] {71,46,74,12},
										new Statement[] {
											new ScopedSubgoal(
												"NewPlayer", new int[] {72,15,74,12},
												"MAMSAgent",
												new Goal(
													new Predicate("post", new Term[] {
														new Variable(Type.STRING, "form_url"),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new ModuleCall("console",
												"NewPlayer", new int[] {73,15,73,71},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Mirror move made at: "),
														new Variable(Type.STRING, "chosen_square")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("NewPlayer","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new If(
										"NewPlayer", new int[] {74,18,78,8},
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "method"),
												Primitive.newPrimitive("PUT")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("NewPlayer","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"NewPlayer", new int[] {74,52,77,12},
											new Statement[] {
												new ScopedSubgoal(
													"NewPlayer", new int[] {75,15,77,12},
													"MAMSAgent",
													new Goal(
														new Predicate("put", new Term[] {
															new Variable(Type.STRING, "form_url"),
															new Variable(Type.STRING, "bodyStr"),
															new Variable(new ObjectType(HttpResponse.class), "response",false)
														})
													)
												),
												new ModuleCall("console",
													"NewPlayer", new int[] {76,15,76,71},
													new Predicate("println", new Term[] {
														Operator.newOperator('+',
															Primitive.newPrimitive("Mirror move made at: "),
															new Variable(Type.STRING, "chosen_square")
														)
													}),
													new DefaultModuleCallAdaptor() {
														public boolean inline() {
															return true;
														}

														public boolean invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Console) intention.getModule("NewPlayer","console")).println(
																(java.lang.String) intention.evaluate(predicate.getTerm(0))
															);
														}
													}
												)
											}
										)
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"NewPlayer", new int[] {81,8,81,27},
			new GoalEvent('+',
				new Goal(
					new Predicate("take_any_free", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"NewPlayer", new int[] {81,26,99,4},
				new Statement[] {
					new If(
						"NewPlayer", new int[] {82,7,99,4},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("11")
						}),
						new Block(
							"NewPlayer", new int[] {82,22,84,8},
							new Statement[] {
								new BeliefUpdate('+',
									"NewPlayer", new int[] {83,11,84,8},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("11")
									})
								)
							}
						),
						new If(
							"NewPlayer", new int[] {84,14,99,4},
							new Predicate("free", new Term[] {
								Primitive.newPrimitive("13")
							}),
							new Block(
								"NewPlayer", new int[] {84,29,86,8},
								new Statement[] {
									new BeliefUpdate('+',
										"NewPlayer", new int[] {85,11,86,8},
										new Predicate("last_move", new Term[] {
											Primitive.newPrimitive("13")
										})
									)
								}
							),
							new If(
								"NewPlayer", new int[] {86,14,99,4},
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("31")
								}),
								new Block(
									"NewPlayer", new int[] {86,29,88,8},
									new Statement[] {
										new BeliefUpdate('+',
											"NewPlayer", new int[] {87,11,88,8},
											new Predicate("last_move", new Term[] {
												Primitive.newPrimitive("31")
											})
										)
									}
								),
								new If(
									"NewPlayer", new int[] {88,14,99,4},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("33")
									}),
									new Block(
										"NewPlayer", new int[] {88,29,90,8},
										new Statement[] {
											new BeliefUpdate('+',
												"NewPlayer", new int[] {89,11,90,8},
												new Predicate("last_move", new Term[] {
													Primitive.newPrimitive("33")
												})
											)
										}
									),
									new If(
										"NewPlayer", new int[] {90,14,99,4},
										new Predicate("free", new Term[] {
											Primitive.newPrimitive("12")
										}),
										new Block(
											"NewPlayer", new int[] {90,29,92,8},
											new Statement[] {
												new BeliefUpdate('+',
													"NewPlayer", new int[] {91,11,92,8},
													new Predicate("last_move", new Term[] {
														Primitive.newPrimitive("12")
													})
												)
											}
										),
										new If(
											"NewPlayer", new int[] {92,14,99,4},
											new Predicate("free", new Term[] {
												Primitive.newPrimitive("21")
											}),
											new Block(
												"NewPlayer", new int[] {92,29,94,8},
												new Statement[] {
													new BeliefUpdate('+',
														"NewPlayer", new int[] {93,11,94,8},
														new Predicate("last_move", new Term[] {
															Primitive.newPrimitive("21")
														})
													)
												}
											),
											new If(
												"NewPlayer", new int[] {94,14,99,4},
												new Predicate("free", new Term[] {
													Primitive.newPrimitive("23")
												}),
												new Block(
													"NewPlayer", new int[] {94,29,96,8},
													new Statement[] {
														new BeliefUpdate('+',
															"NewPlayer", new int[] {95,11,96,8},
															new Predicate("last_move", new Term[] {
																Primitive.newPrimitive("23")
															})
														)
													}
												),
												new If(
													"NewPlayer", new int[] {96,14,99,4},
													new Predicate("free", new Term[] {
														Primitive.newPrimitive("32")
													}),
													new Block(
														"NewPlayer", new int[] {96,29,98,8},
														new Statement[] {
															new BeliefUpdate('+',
																"NewPlayer", new int[] {97,11,98,8},
																new Predicate("last_move", new Term[] {
																	Primitive.newPrimitive("32")
																})
															)
														}
													)
												)
											)
										)
									)
								)
							)
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("corner_map", new Term[] {
				Primitive.newPrimitive("11"),
				Primitive.newPrimitive("33")
			})
		);
		agent.initialize(
			new Predicate("corner_map", new Term[] {
				Primitive.newPrimitive("13"),
				Primitive.newPrimitive("31")
			})
		);
		agent.initialize(
			new Predicate("corner_map", new Term[] {
				Primitive.newPrimitive("31"),
				Primitive.newPrimitive("13")
			})
		);
		agent.initialize(
			new Predicate("corner_map", new Term[] {
				Primitive.newPrimitive("33"),
				Primitive.newPrimitive("11")
			})
		);
		agent.initialize(
			new Predicate("edge_map", new Term[] {
				Primitive.newPrimitive("12"),
				Primitive.newPrimitive("32")
			})
		);
		agent.initialize(
			new Predicate("edge_map", new Term[] {
				Primitive.newPrimitive("21"),
				Primitive.newPrimitive("23")
			})
		);
		agent.initialize(
			new Predicate("edge_map", new Term[] {
				Primitive.newPrimitive("23"),
				Primitive.newPrimitive("21")
			})
		);
		agent.initialize(
			new Predicate("edge_map", new Term[] {
				Primitive.newPrimitive("32"),
				Primitive.newPrimitive("12")
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		return fragment;
	}

	public static void main(String[] args) {
		Scheduler.setStrategy(new TestSchedulerStrategy());
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new NewPlayer().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: NewPlayer");
			}
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}

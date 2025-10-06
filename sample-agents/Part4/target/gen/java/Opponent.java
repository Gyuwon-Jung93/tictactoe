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

public class Opponent extends ASTRAClass {
	public Opponent() {
		setParents(new Class[] {Player.class});
		addRule(new Rule(
			"Opponent", new int[] {8,9,8,108},
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
				"Opponent", new int[] {8,107,47,5},
				new Statement[] {
					new ModuleCall("console",
						"Opponent", new int[] {9,8,9,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Opponent handle_move called")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new If(
						"Opponent", new int[] {11,8,47,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("22")
						}),
						new Block(
							"Opponent", new int[] {11,23,16,9},
							new Statement[] {
								new ModuleCall("console",
									"Opponent", new int[] {12,12,12,67},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Opponent: Center is free, taking it!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new BeliefUpdate('+',
									"Opponent", new int[] {13,12,16,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("22")
									})
								),
								new BeliefUpdate('+',
									"Opponent", new int[] {14,12,16,9},
									new Predicate("move", new Term[] {
										Primitive.newPrimitive("22"),
										Primitive.newPrimitive("ttt:OPlayerRole")
									})
								),
								new BeliefUpdate('-',
									"Opponent", new int[] {15,12,16,9},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("22")
									})
								)
							}
						),
						new If(
							"Opponent", new int[] {18,13,47,5},
							new NOT(
								new Predicate("last_move", new Term[] {
									new Variable(Type.STRING, "anyMove",false)
								})
							),
							new Block(
								"Opponent", new int[] {18,44,20,9},
								new Statement[] {
									new Subgoal(
										"Opponent", new int[] {19,12,20,9},
										new Goal(
											new Predicate("try_corners", new Term[] {})
										)
									)
								}
							),
							new If(
								"Opponent", new int[] {22,13,47,5},
								new NOT(
									new Predicate("last_move", new Term[] {
										new Variable(Type.STRING, "anyMove",false)
									})
								),
								new Block(
									"Opponent", new int[] {22,44,24,9},
									new Statement[] {
										new Subgoal(
											"Opponent", new int[] {23,12,24,9},
											new Goal(
												new Predicate("take_any_free", new Term[] {})
											)
										)
									}
								)
							)
						)
					),
					new If(
						"Opponent", new int[] {27,8,47,5},
						new Predicate("last_move", new Term[] {
							new Variable(Type.STRING, "chosen_square",false)
						}),
						new Block(
							"Opponent", new int[] {27,44,46,9},
							new Statement[] {
								new ModuleCall("console",
									"Opponent", new int[] {28,12,28,79},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Opponent making move to square: "),
											new Variable(Type.STRING, "chosen_square")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Opponent", new int[] {29,12,46,9},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Opponent","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Opponent","builder")).createObject(
												);
											}
										}
									)
								),
								new Query(
									"Opponent", new int[] {30,12,30,59},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "agentURL",false)
									})
								),
								new ModuleCall("builder",
									"Opponent", new int[] {31,12,31,58},
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
											return ((mams.JSONBuilder) intention.getModule("Opponent","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new ModuleCall("builder",
									"Opponent", new int[] {32,12,32,70},
									new Predicate("addProperty", new Term[] {
										new Variable(new ObjectType(JsonNode.class), "bodyJson"),
										Primitive.newPrimitive("ttt:square"),
										new Variable(Type.STRING, "chosen_square")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((mams.JSONBuilder) intention.getModule("Opponent","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Opponent", new int[] {33,12,46,9},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Opponent","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Opponent","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Opponent", new int[] {35,12,35,69},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Opponent move request body: "),
											new Variable(Type.STRING, "bodyStr")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Opponent", new int[] {37,12,46,9},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Opponent","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Opponent", new int[] {37,47,40,13},
										new Statement[] {
											new ScopedSubgoal(
												"Opponent", new int[] {38,16,40,13},
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
												"Opponent", new int[] {39,16,39,70},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Opponent moved to: "),
														new Variable(Type.STRING, "chosen_square")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new If(
										"Opponent", new int[] {40,19,46,9},
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "method"),
												Primitive.newPrimitive("PUT")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Opponent","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"Opponent", new int[] {40,53,43,13},
											new Statement[] {
												new ScopedSubgoal(
													"Opponent", new int[] {41,16,43,13},
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
													"Opponent", new int[] {42,16,42,70},
													new Predicate("println", new Term[] {
														Operator.newOperator('+',
															Primitive.newPrimitive("Opponent moved to: "),
															new Variable(Type.STRING, "chosen_square")
														)
													}),
													new DefaultModuleCallAdaptor() {
														public boolean inline() {
															return true;
														}

														public boolean invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Console) intention.getModule("Opponent","console")).println(
																(java.lang.String) intention.evaluate(predicate.getTerm(0))
															);
														}
													}
												)
											}
										)
									)
								),
								new BeliefUpdate('-',
									"Opponent", new int[] {44,12,46,9},
									new Predicate("last_move", new Term[] {
										new Variable(Type.STRING, "chosen_square")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {50,9,50,26},
			new GoalEvent('+',
				new Goal(
					new Predicate("try_corners", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Opponent", new int[] {50,25,61,5},
				new Statement[] {
					new If(
						"Opponent", new int[] {52,8,61,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("11")
						}),
						new Block(
							"Opponent", new int[] {52,23,54,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Opponent", new int[] {53,12,54,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("11")
									})
								)
							}
						),
						new If(
							"Opponent", new int[] {54,15,61,5},
							new Predicate("free", new Term[] {
								Primitive.newPrimitive("13")
							}),
							new Block(
								"Opponent", new int[] {54,30,56,9},
								new Statement[] {
									new BeliefUpdate('+',
										"Opponent", new int[] {55,12,56,9},
										new Predicate("last_move", new Term[] {
											Primitive.newPrimitive("13")
										})
									)
								}
							),
							new If(
								"Opponent", new int[] {56,15,61,5},
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("31")
								}),
								new Block(
									"Opponent", new int[] {56,30,58,9},
									new Statement[] {
										new BeliefUpdate('+',
											"Opponent", new int[] {57,12,58,9},
											new Predicate("last_move", new Term[] {
												Primitive.newPrimitive("31")
											})
										)
									}
								),
								new If(
									"Opponent", new int[] {58,15,61,5},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("33")
									}),
									new Block(
										"Opponent", new int[] {58,30,60,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Opponent", new int[] {59,12,60,9},
												new Predicate("last_move", new Term[] {
													Primitive.newPrimitive("33")
												})
											)
										}
									)
								)
							)
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Opponent", new int[] {64,9,64,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("take_any_free", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Opponent", new int[] {64,27,75,5},
				new Statement[] {
					new If(
						"Opponent", new int[] {66,8,75,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("12")
						}),
						new Block(
							"Opponent", new int[] {66,23,68,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Opponent", new int[] {67,12,68,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("12")
									})
								)
							}
						),
						new If(
							"Opponent", new int[] {68,15,75,5},
							new Predicate("free", new Term[] {
								Primitive.newPrimitive("21")
							}),
							new Block(
								"Opponent", new int[] {68,30,70,9},
								new Statement[] {
									new BeliefUpdate('+',
										"Opponent", new int[] {69,12,70,9},
										new Predicate("last_move", new Term[] {
											Primitive.newPrimitive("21")
										})
									)
								}
							),
							new If(
								"Opponent", new int[] {70,15,75,5},
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("23")
								}),
								new Block(
									"Opponent", new int[] {70,30,72,9},
									new Statement[] {
										new BeliefUpdate('+',
											"Opponent", new int[] {71,12,72,9},
											new Predicate("last_move", new Term[] {
												Primitive.newPrimitive("23")
											})
										)
									}
								),
								new If(
									"Opponent", new int[] {72,15,75,5},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("32")
									}),
									new Block(
										"Opponent", new int[] {72,30,74,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Opponent", new int[] {73,12,74,9},
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
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
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
			astra.core.Agent agent = new Opponent().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Opponent");
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

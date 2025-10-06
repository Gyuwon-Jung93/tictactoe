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

public class Better extends ASTRAClass {
	public Better() {
		setParents(new Class[] {Player.class});
		addRule(new Rule(
			"Better", new int[] {25,9,25,108},
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
				"Better", new int[] {25,107,73,9},
				new Statement[] {
					new ModuleCall("console",
						"Better", new int[] {26,8,26,52},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Better handle_move called")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Better","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Better", new int[] {28,8,73,9},
						new Goal(
							new Predicate("check_winning_move", new Term[] {
								new Variable(Type.STRING, "role")
							})
						)
					),
					new If(
						"Better", new int[] {31,8,73,9},
						new NOT(
							new Predicate("last_move", new Term[] {
								new Variable(Type.STRING, "anyMove",false)
							})
						),
						new Block(
							"Better", new int[] {31,39,33,9},
							new Statement[] {
								new Subgoal(
									"Better", new int[] {32,12,33,9},
									new Goal(
										new Predicate("block_opponent_win", new Term[] {
											new Variable(Type.STRING, "role")
										})
									)
								)
							}
						)
					),
					new If(
						"Better", new int[] {36,8,73,9},
						new NOT(
							new Predicate("last_move", new Term[] {
								new Variable(Type.STRING, "anyMove",false)
							})
						),
						new Block(
							"Better", new int[] {36,39,39,9},
							new Statement[] {
								new ModuleCall("console",
									"Better", new int[] {37,12,37,47},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Trying center...")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Better","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Better", new int[] {38,12,39,9},
									new Goal(
										new Predicate("try_center", new Term[] {})
									)
								)
							}
						)
					),
					new If(
						"Better", new int[] {42,8,73,9},
						new NOT(
							new Predicate("last_move", new Term[] {
								new Variable(Type.STRING, "anyMove",false)
							})
						),
						new Block(
							"Better", new int[] {42,39,44,9},
							new Statement[] {
								new Subgoal(
									"Better", new int[] {43,12,44,9},
									new Goal(
										new Predicate("try_corners", new Term[] {
											new Variable(Type.STRING, "role")
										})
									)
								)
							}
						)
					),
					new If(
						"Better", new int[] {47,8,73,9},
						new NOT(
							new Predicate("last_move", new Term[] {
								new Variable(Type.STRING, "anyMove",false)
							})
						),
						new Block(
							"Better", new int[] {47,39,49,9},
							new Statement[] {
								new Subgoal(
									"Better", new int[] {48,12,49,9},
									new Goal(
										new Predicate("take_any_free", new Term[] {})
									)
								)
							}
						)
					),
					new If(
						"Better", new int[] {52,8,73,9},
						new Predicate("last_move", new Term[] {
							new Variable(Type.STRING, "chosen_square",false)
						}),
						new Block(
							"Better", new int[] {52,44,69,16},
							new Statement[] {
								new ModuleCall("console",
									"Better", new int[] {53,12,53,70},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Making move to square: "),
											new Variable(Type.STRING, "chosen_square")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Better","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Better", new int[] {55,16,69,16},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Better","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Better","builder")).createObject(
												);
											}
										}
									)
								),
								new Query(
									"Better", new int[] {56,16,56,63},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "agentURL",false)
									})
								),
								new ModuleCall("builder",
									"Better", new int[] {57,16,57,62},
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
											return ((mams.JSONBuilder) intention.getModule("Better","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new ModuleCall("builder",
									"Better", new int[] {58,16,58,74},
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
											return ((mams.JSONBuilder) intention.getModule("Better","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Better", new int[] {59,16,69,16},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Better","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Better","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Better", new int[] {60,16,60,71},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Better move request body: "),
											new Variable(Type.STRING, "bodyStr")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Better","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Better", new int[] {62,16,69,16},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Better","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Better", new int[] {62,51,65,17},
										new Statement[] {
											new ScopedSubgoal(
												"Better", new int[] {63,20,65,17},
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
												"Better", new int[] {64,20,64,76},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Better made move at: "),
														new Variable(Type.STRING, "chosen_square")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Better","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new If(
										"Better", new int[] {65,23,69,16},
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "method"),
												Primitive.newPrimitive("PUT")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Better","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"Better", new int[] {65,57,68,17},
											new Statement[] {
												new ScopedSubgoal(
													"Better", new int[] {66,20,68,17},
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
													"Better", new int[] {67,20,67,76},
													new Predicate("println", new Term[] {
														Operator.newOperator('+',
															Primitive.newPrimitive("Better made move at: "),
															new Variable(Type.STRING, "chosen_square")
														)
													}),
													new DefaultModuleCallAdaptor() {
														public boolean inline() {
															return true;
														}

														public boolean invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Console) intention.getModule("Better","console")).println(
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
						),
						new Block(
							"Better", new int[] {69,22,73,9},
							new Statement[] {
								new ModuleCall("console",
									"Better", new int[] {70,12,70,54},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Better: No move chosen!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Better","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Better", new int[] {76,9,76,44},
			new GoalEvent('+',
				new Goal(
					new Predicate("check_winning_move", new Term[] {
						new Variable(Type.STRING, "role",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Better", new int[] {76,43,94,5},
				new Statement[] {
					new Query(
						"Better", new int[] {77,8,77,48},
						new Predicate("winning_lines", new Term[] {
							new ListTerm(new Term[] {
								new ListTerm(new Term[] {
									new Variable(Type.LIST, "all_lines",false)
								})
							})
						})
					),
					new ForAll(
						"Better", new int[] {78,8,78,37},
						new Variable(Type.LIST, "line",false),
						new Variable(Type.LIST, "all_lines"),
						new Block(
							"Better", new int[] {78,38,94,5},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "my_count"),
									"Better", new int[] {79,12,93,9},
									Primitive.newPrimitive(0)
								),
								new Declaration(
									new Variable(Type.STRING, "empty_square"),
									"Better", new int[] {80,12,93,9},
									Primitive.newPrimitive("")
								),
								new ForAll(
									"Better", new int[] {82,12,82,36},
									new Variable(Type.STRING, "sq",false),
									new Variable(Type.LIST, "line"),
									new Block(
										"Better", new int[] {82,37,93,9},
										new Statement[] {
											new If(
												"Better", new int[] {83,16,88,13},
												new Predicate("move", new Term[] {
													new Variable(Type.STRING, "sq"),
													new Variable(Type.STRING, "role")
												}),
												new Block(
													"Better", new int[] {83,35,85,17},
													new Statement[] {
														new Assignment(
															new Variable(Type.INTEGER, "my_count"),
															"Better", new int[] {84,20,85,17},
															Operator.newOperator('+',
																new Variable(Type.INTEGER, "my_count"),
																Primitive.newPrimitive(1)
															)
														)
													}
												),
												new If(
													"Better", new int[] {85,23,88,13},
													new Predicate("free", new Term[] {
														new Variable(Type.STRING, "sq")
													}),
													new Block(
														"Better", new int[] {85,36,87,17},
														new Statement[] {
															new Assignment(
																new Variable(Type.STRING, "empty_square"),
																"Better", new int[] {86,20,87,17},
																new Variable(Type.STRING, "sq")
															)
														}
													)
												)
											)
										}
									)
								),
								new If(
									"Better", new int[] {90,12,93,9},
									new AND(
										new Comparison("==",
											new Variable(Type.INTEGER, "my_count"),
											Primitive.newPrimitive(2)
										),
										new NOT(
											new ModuleFormula("strings",
												new Predicate("equal", new Term[] {
													new Variable(Type.STRING, "empty_square"),
													Primitive.newPrimitive("")
												}),
											new ModuleFormulaAdaptor() {
													public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Strings) visitor.agent().getModule("Better","strings")).equal(
															(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
															(java.lang.String) visitor.evaluate(predicate.getTerm(1))
														);
												}
											}
												)
										)
									),
									new Block(
										"Better", new int[] {90,64,92,13},
										new Statement[] {
											new BeliefUpdate('+',
												"Better", new int[] {91,16,92,13},
												new Predicate("last_move", new Term[] {
													new Variable(Type.STRING, "empty_square")
												})
											)
										}
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Better", new int[] {97,9,97,44},
			new GoalEvent('+',
				new Goal(
					new Predicate("block_opponent_win", new Term[] {
						new Variable(Type.STRING, "role",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Better", new int[] {97,43,115,5},
				new Statement[] {
					new Query(
						"Better", new int[] {98,8,98,48},
						new Predicate("winning_lines", new Term[] {
							new ListTerm(new Term[] {
								new ListTerm(new Term[] {
									new Variable(Type.LIST, "all_lines",false)
								})
							})
						})
					),
					new ForAll(
						"Better", new int[] {99,8,99,37},
						new Variable(Type.LIST, "line",false),
						new Variable(Type.LIST, "all_lines"),
						new Block(
							"Better", new int[] {99,38,115,5},
							new Statement[] {
								new Declaration(
									new Variable(Type.INTEGER, "opp_count"),
									"Better", new int[] {100,12,114,9},
									Primitive.newPrimitive(0)
								),
								new Declaration(
									new Variable(Type.STRING, "empty_square"),
									"Better", new int[] {101,12,114,9},
									Primitive.newPrimitive("")
								),
								new ForAll(
									"Better", new int[] {103,12,103,36},
									new Variable(Type.STRING, "sq",false),
									new Variable(Type.LIST, "line"),
									new Block(
										"Better", new int[] {103,37,114,9},
										new Statement[] {
											new If(
												"Better", new int[] {104,16,109,13},
												new AND(
													new Predicate("move", new Term[] {
														new Variable(Type.STRING, "sq"),
														new Variable(Type.STRING, "anyPlayer",false)
													}),
													new NOT(
														new ModuleFormula("strings",
															new Predicate("equal", new Term[] {
																new Variable(Type.STRING, "anyPlayer"),
																new Variable(Type.STRING, "role")
															}),
														new ModuleFormulaAdaptor() {
																public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.Strings) visitor.agent().getModule("Better","strings")).equal(
																		(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																		(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																	);
															}
														}
															)
													)
												),
												new Block(
													"Better", new int[] {104,81,106,17},
													new Statement[] {
														new Assignment(
															new Variable(Type.INTEGER, "opp_count"),
															"Better", new int[] {105,20,106,17},
															Operator.newOperator('+',
																new Variable(Type.INTEGER, "opp_count"),
																Primitive.newPrimitive(1)
															)
														)
													}
												),
												new If(
													"Better", new int[] {106,23,109,13},
													new Predicate("free", new Term[] {
														new Variable(Type.STRING, "sq")
													}),
													new Block(
														"Better", new int[] {106,36,108,17},
														new Statement[] {
															new Assignment(
																new Variable(Type.STRING, "empty_square"),
																"Better", new int[] {107,20,108,17},
																new Variable(Type.STRING, "sq")
															)
														}
													)
												)
											)
										}
									)
								),
								new If(
									"Better", new int[] {111,12,114,9},
									new AND(
										new Comparison("==",
											new Variable(Type.INTEGER, "opp_count"),
											Primitive.newPrimitive(2)
										),
										new NOT(
											new ModuleFormula("strings",
												new Predicate("equal", new Term[] {
													new Variable(Type.STRING, "empty_square"),
													Primitive.newPrimitive("")
												}),
											new ModuleFormulaAdaptor() {
													public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Strings) visitor.agent().getModule("Better","strings")).equal(
															(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
															(java.lang.String) visitor.evaluate(predicate.getTerm(1))
														);
												}
											}
												)
										)
									),
									new Block(
										"Better", new int[] {111,65,113,13},
										new Statement[] {
											new BeliefUpdate('+',
												"Better", new int[] {112,16,113,13},
												new Predicate("last_move", new Term[] {
													new Variable(Type.STRING, "empty_square")
												})
											)
										}
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Better", new int[] {118,9,118,25},
			new GoalEvent('+',
				new Goal(
					new Predicate("try_center", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Better", new int[] {118,24,125,5},
				new Statement[] {
					new If(
						"Better", new int[] {119,8,125,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("22")
						}),
						new Block(
							"Better", new int[] {119,23,124,9},
							new Statement[] {
								new ModuleCall("console",
									"Better", new int[] {120,12,120,65},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Better: Center is free, taking it!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Better","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new BeliefUpdate('+',
									"Better", new int[] {121,12,124,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("22")
									})
								),
								new BeliefUpdate('+',
									"Better", new int[] {122,12,124,9},
									new Predicate("move", new Term[] {
										Primitive.newPrimitive("22"),
										Primitive.newPrimitive("ttt:XPlayerRole")
									})
								),
								new BeliefUpdate('-',
									"Better", new int[] {123,12,124,9},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("22")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Better", new int[] {128,9,128,37},
			new GoalEvent('+',
				new Goal(
					new Predicate("try_corners", new Term[] {
						new Variable(Type.STRING, "role",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Better", new int[] {128,36,139,5},
				new Statement[] {
					new If(
						"Better", new int[] {130,8,139,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("11")
						}),
						new Block(
							"Better", new int[] {130,23,132,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Better", new int[] {131,12,132,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("11")
									})
								)
							}
						),
						new If(
							"Better", new int[] {132,15,139,5},
							new AND(
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("33")
								}),
								new Predicate("move", new Term[] {
									Primitive.newPrimitive("11"),
									new Variable(Type.STRING, "role")
								})
							),
							new Block(
								"Better", new int[] {132,49,134,9},
								new Statement[] {
									new BeliefUpdate('+',
										"Better", new int[] {133,12,134,9},
										new Predicate("last_move", new Term[] {
											Primitive.newPrimitive("33")
										})
									)
								}
							),
							new If(
								"Better", new int[] {134,15,139,5},
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("13")
								}),
								new Block(
									"Better", new int[] {134,30,136,9},
									new Statement[] {
										new BeliefUpdate('+',
											"Better", new int[] {135,12,136,9},
											new Predicate("last_move", new Term[] {
												Primitive.newPrimitive("13")
											})
										)
									}
								),
								new If(
									"Better", new int[] {136,15,139,5},
									new AND(
										new Predicate("free", new Term[] {
											Primitive.newPrimitive("31")
										}),
										new Predicate("move", new Term[] {
											Primitive.newPrimitive("13"),
											new Variable(Type.STRING, "role")
										})
									),
									new Block(
										"Better", new int[] {136,49,138,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Better", new int[] {137,12,138,9},
												new Predicate("last_move", new Term[] {
													Primitive.newPrimitive("31")
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
			"Better", new int[] {142,9,142,28},
			new GoalEvent('+',
				new Goal(
					new Predicate("take_any_free", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Better", new int[] {142,27,152,5},
				new Statement[] {
					new If(
						"Better", new int[] {143,8,152,5},
						new Predicate("free", new Term[] {
							Primitive.newPrimitive("12")
						}),
						new Block(
							"Better", new int[] {143,23,145,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Better", new int[] {144,12,145,9},
									new Predicate("last_move", new Term[] {
										Primitive.newPrimitive("12")
									})
								)
							}
						),
						new If(
							"Better", new int[] {145,15,152,5},
							new Predicate("free", new Term[] {
								Primitive.newPrimitive("21")
							}),
							new Block(
								"Better", new int[] {145,30,147,9},
								new Statement[] {
									new BeliefUpdate('+',
										"Better", new int[] {146,12,147,9},
										new Predicate("last_move", new Term[] {
											Primitive.newPrimitive("21")
										})
									)
								}
							),
							new If(
								"Better", new int[] {147,15,152,5},
								new Predicate("free", new Term[] {
									Primitive.newPrimitive("23")
								}),
								new Block(
									"Better", new int[] {147,30,149,9},
									new Statement[] {
										new BeliefUpdate('+',
											"Better", new int[] {148,12,149,9},
											new Predicate("last_move", new Term[] {
												Primitive.newPrimitive("23")
											})
										)
									}
								),
								new If(
									"Better", new int[] {149,15,152,5},
									new Predicate("free", new Term[] {
										Primitive.newPrimitive("32")
									}),
									new Block(
										"Better", new int[] {149,30,151,9},
										new Statement[] {
											new BeliefUpdate('+',
												"Better", new int[] {150,12,151,9},
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
		agent.initialize(
			new Predicate("winning_lines", new Term[] {
				new ListTerm(new Term[] {
					new ListTerm(new Term[] {
						new ListTerm(new Term[] {
							Primitive.newPrimitive("11"),
							Primitive.newPrimitive("12"),
							Primitive.newPrimitive("13")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("21"),
							Primitive.newPrimitive("22"),
							Primitive.newPrimitive("23")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("31"),
							Primitive.newPrimitive("32"),
							Primitive.newPrimitive("33")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("11"),
							Primitive.newPrimitive("21"),
							Primitive.newPrimitive("31")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("12"),
							Primitive.newPrimitive("22"),
							Primitive.newPrimitive("32")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("13"),
							Primitive.newPrimitive("23"),
							Primitive.newPrimitive("33")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("11"),
							Primitive.newPrimitive("22"),
							Primitive.newPrimitive("33")
						}),
						new ListTerm(new Term[] {
							Primitive.newPrimitive("13"),
							Primitive.newPrimitive("22"),
							Primitive.newPrimitive("31")
						})
					})
				})
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
			astra.core.Agent agent = new Better().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Better");
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

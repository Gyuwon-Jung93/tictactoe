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

public class Player extends ASTRAClass {
	public Player() {
		setParents(new Class[] {Shared.class});
		addRule(new Rule(
			"Player", new int[] {38,9,38,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new ListTerm(new Term[] {
							new Variable(Type.STRING, "url",false)
						})
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {38,30,58,5},
				new Statement[] {
					new BeliefUpdate('+',
						"Player", new int[] {39,8,58,5},
						new Predicate("api_index_url", new Term[] {
							new Variable(Type.STRING, "url")
						})
					),
					new ScopedSubgoal(
						"Player", new int[] {42,8,58,5},
						"MAMSAgent",
						new Goal(
							new Predicate("init", new Term[] {})
						)
					),
					new ScopedSubgoal(
						"Player", new int[] {43,8,58,5},
						"MAMSAgent",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("base")
							})
						)
					),
					new ScopedSubgoal(
						"Player", new int[] {44,8,58,5},
						"IntegratedInbox",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("inbox")
							})
						)
					),
					new Subgoal(
						"Player", new int[] {47,8,58,5},
						new Goal(
							new Predicate("itemProperty", new Term[] {
								Primitive.newPrimitive("base"),
								Primitive.newPrimitive("uri"),
								new Variable(Type.FUNCTION, "agentUri",false)
							})
						)
					),
					new Declaration(
						new Variable(Type.STRING, "uri"),
						"Player", new int[] {48,8,58,5},
						new ModuleTerm("F", Type.STRING,
							new Predicate("valueAsString", new Term[] {
								new Variable(Type.FUNCTION, "agentUri"),
								Primitive.newPrimitive(0)
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Functions) intention.getModule("Player","F")).valueAsString(
										(astra.term.Funct) intention.evaluate(predicate.getTerm(0)),
										(int) intention.evaluate(predicate.getTerm(1))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Functions) visitor.agent().getModule("Player","F")).valueAsString(
										(astra.term.Funct) visitor.evaluate(predicate.getTerm(0)),
										(int) visitor.evaluate(predicate.getTerm(1))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {50,8,58,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@id"),
							new Variable(Type.STRING, "uri")
						})
					),
					new BeliefUpdate('+',
						"Player", new int[] {52,8,58,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@type"),
							Primitive.newPrimitive("ttt:Agent")
						})
					),
					new Declaration(
						new Variable(Type.STRING, "ontology"),
						"Player", new int[] {54,8,58,5},
						new ModuleTerm("ttt", Type.STRING,
							new Predicate("qualifiedName", new Term[] {
								Primitive.newPrimitive("")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.jena.RDFSchema) intention.getModule("Player","ttt")).qualifiedName(
										(java.lang.String) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).qualifiedName(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"Player", new int[] {55,8,58,5},
						new Predicate("agent_attributes", new Term[] {
							Primitive.newPrimitive("@context"),
							Operator.newOperator('+',
								Primitive.newPrimitive("{\"ttt\": \""),
								Operator.newOperator('+',
									new Variable(Type.STRING, "ontology"),
									Primitive.newPrimitive("\"}")
								)
							)
						})
					),
					new Subgoal(
						"Player", new int[] {57,8,58,5},
						new Goal(
							new Predicate("get_index_page", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {60,9,60,43},
			new GoalEvent('+',
				new Goal(
					new Predicate("update_board_state", new Term[] {
						new Variable(Type.STRING, "url",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {60,42,82,5},
				new Statement[] {
					new ForEach(
						"Player", new int[] {62,8,82,5},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "sq",false),
							new Variable(Type.STRING, "pl",false)
						}),
						new Block(
							"Player", new int[] {62,44,64,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {63,12,64,9},
									new Predicate("move", new Term[] {
										new Variable(Type.STRING, "sq"),
										new Variable(Type.STRING, "pl")
									})
								)
							}
						)
					),
					new ForEach(
						"Player", new int[] {65,8,82,5},
						new Predicate("free", new Term[] {
							new Variable(Type.STRING, "sq",false)
						}),
						new Block(
							"Player", new int[] {65,33,67,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {66,12,67,9},
									new Predicate("free", new Term[] {
										new Variable(Type.STRING, "sq")
									})
								)
							}
						)
					),
					new Declaration(
						new Variable(Type.LIST, "squares"),
						"Player", new int[] {70,8,82,5},
						new ListTerm(new Term[] {
							Primitive.newPrimitive("11"),
							Primitive.newPrimitive("12"),
							Primitive.newPrimitive("13"),
							Primitive.newPrimitive("21"),
							Primitive.newPrimitive("22"),
							Primitive.newPrimitive("23"),
							Primitive.newPrimitive("31"),
							Primitive.newPrimitive("32"),
							Primitive.newPrimitive("33")
						})
					),
					new ForAll(
						"Player", new int[] {71,8,71,35},
						new Variable(Type.STRING, "sq",false),
						new Variable(Type.LIST, "squares"),
						new Block(
							"Player", new int[] {71,36,82,5},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {72,12,73,9},
									new Predicate("free", new Term[] {
										new Variable(Type.STRING, "sq")
									})
								)
							}
						)
					),
					new ForEach(
						"Player", new int[] {76,8,82,5},
						new ModuleFormula("ttt",
							new Predicate("hasMove", new Term[] {
								new Variable(Type.STRING, "url"),
								new Variable(Type.STRING, "move_id",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						),
						new Block(
							"Player", new int[] {76,50,81,9},
							new Statement[] {
								new Query(
									"Player", new int[] {77,12,77,55},
									new ModuleFormula("ttt",
										new Predicate("inSquare", new Term[] {
											new Variable(Type.STRING, "move_id"),
											new Variable(Type.STRING, "square",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new Query(
									"Player", new int[] {78,12,78,58},
									new ModuleFormula("ttt",
										new Predicate("moveTakenBy", new Term[] {
											new Variable(Type.STRING, "move_id"),
											new Variable(Type.STRING, "player",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new BeliefUpdate('+',
									"Player", new int[] {79,12,81,9},
									new Predicate("move", new Term[] {
										new Variable(Type.STRING, "square"),
										new Variable(Type.STRING, "player")
									})
								),
								new BeliefUpdate('-',
									"Player", new int[] {80,12,81,9},
									new Predicate("free", new Term[] {
										new Variable(Type.STRING, "square")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {84,9,84,65},
			new GoalEvent('+',
				new Goal(
					new Predicate("make_move", new Term[] {
						new Variable(Type.STRING, "form_url",false),
						new Variable(Type.STRING, "method",false),
						new Variable(Type.STRING, "id",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {84,64,84,66},
				new Statement[] {
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {86,9,86,111},
			new GoalEvent('+',
				new Goal(
					new Predicate("get_index_page", new Term[] {})
				)
			),
			new AND(
				new NOT(
					new Predicate("game", new Term[] {
						new Variable(Type.STRING, "id",false),
						new Variable(Type.STRING, "role",false),
						new Variable(Type.STRING, "opponent",false)
					})
				),
				new Predicate("api_index_url", new Term[] {
					new Variable(Type.STRING, "game_url",false)
				})
			),
			new Block(
				"Player", new int[] {86,110,93,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {87,8,93,5},
						new Block(
							"Player", new int[] {87,12,89,9},
							new Statement[] {
								new ModuleCall("knowledgeStoreGame",
									"Player", new int[] {88,12,88,64},
									new Predicate("getKnowledge", new Term[] {
										new Variable(Type.STRING, "game_url"),
										Primitive.newPrimitive("JSON-LD")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).getKnowledge(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						),
						new Block(
							"Player", new int[] {89,18,93,5},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {90,12,90,67},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Failed to access API at: "),
											new Variable(Type.STRING, "game_url")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Player", new int[] {91,12,92,9},
									new Goal(
										new Predicate("handle_api_error", new Term[] {
											new Variable(Type.STRING, "game_url")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {95,13,95,50},
			new GoalEvent('+',
				new Goal(
					new Predicate("handle_api_error", new Term[] {
						new Variable(Type.STRING, "endpoint",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {95,49,111,5},
				new Statement[] {
					new ForEach(
						"Player", new int[] {96,8,111,5},
						new Predicate("api_error_count", new Term[] {
							new Variable(Type.INTEGER, "count",false)
						}),
						new Block(
							"Player", new int[] {96,44,110,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {97,12,110,9},
									new Predicate("api_error_count", new Term[] {
										new Variable(Type.INTEGER, "count")
									})
								),
								new BeliefUpdate('+',
									"Player", new int[] {98,12,110,9},
									new Predicate("api_error_count", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new If(
									"Player", new int[] {100,12,110,9},
									new Comparison(">=",
										new Variable(Type.INTEGER, "count"),
										Primitive.newPrimitive(10)
									),
									new Block(
										"Player", new int[] {100,27,105,13},
										new Statement[] {
											new BeliefUpdate('+',
												"Player", new int[] {101,16,105,13},
												new Predicate("api_unavailable", new Term[] {
													Primitive.newPrimitive(true)
												})
											),
											new BeliefUpdate('+',
												"Player", new int[] {102,16,105,13},
												new Predicate("connection_lost", new Term[] {
													new Variable(Type.STRING, "endpoint")
												})
											),
											new ModuleCall("console",
												"Player", new int[] {103,16,103,93},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("API appears to be unavailable after "),
														Operator.newOperator('+',
															new Variable(Type.INTEGER, "count"),
															Primitive.newPrimitive(" attempts")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Send("Player", new int[] {104,16,104,59},
												new Performative("inform"),
												Primitive.newPrimitive("main"),
												new Predicate("api_failure", new Term[] {
													new Variable(Type.STRING, "endpoint")
												})
											)
										}
									),
									new Block(
										"Player", new int[] {105,19,110,9},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {106,16,106,73},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("API error count: "),
														Operator.newOperator('+',
															new Brackets(
																Operator.newOperator('+',
																	new Variable(Type.INTEGER, "count"),
																	Primitive.newPrimitive(1)
																)
															),
															Primitive.newPrimitive("/10")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("system",
												"Player", new int[] {107,16,107,33},
												new Predicate("sleep", new Term[] {
													Primitive.newPrimitive(1000)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return false;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Player","system")).sleep(
															(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Subgoal(
												"Player", new int[] {108,16,109,13},
												new Goal(
													new Predicate("get_index_page", new Term[] {})
												)
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
			"Player", new int[] {113,8,113,128},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new AND(
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				}),
				new ModuleFormula("strings",
					new Predicate("contains", new Term[] {
						new Variable(Type.STRING, "url"),
						Primitive.newPrimitive("result")
					}),
				new ModuleFormulaAdaptor() {
						public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
							return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).contains(
								(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
								(java.lang.String) visitor.evaluate(predicate.getTerm(1))
							);
					}
				}
					)
			),
			new Block(
				"Player", new int[] {113,127,138,1},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {114,4,138,1},
						new Block(
							"Player", new int[] {114,8,134,5},
							new Statement[] {
								new If(
									"Player", new int[] {115,8,134,5},
									new ModuleFormula("ttt",
										new Predicate("TicTacToeResult", new Term[] {
											new Variable(Type.STRING, "url"),
											new Variable(Type.STRING, "winner",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Player","ttt")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									),
									new Block(
										"Player", new int[] {115,53,125,9},
										new Statement[] {
											new ForEach(
												"Player", new int[] {116,12,125,9},
												new Predicate("agent_attributes", new Term[] {
													Primitive.newPrimitive("@id"),
													new Variable(Type.STRING, "myUri",false)
												}),
												new Block(
													"Player", new int[] {116,59,124,13},
													new Statement[] {
														new If(
															"Player", new int[] {117,16,124,13},
															new ModuleFormula("strings",
																new Predicate("equal", new Term[] {
																	new Variable(Type.STRING, "winner"),
																	new Variable(Type.STRING, "role")
																}),
															new ModuleFormulaAdaptor() {
																	public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																		return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).equal(
																			(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																			(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																		);
																}
															}
																),
															new Block(
																"Player", new int[] {117,49,120,17},
																new Statement[] {
																	new ModuleCall("console",
																		"Player", new int[] {118,20,118,54},
																		new Predicate("println", new Term[] {
																			Primitive.newPrimitive("I won the game!")
																		}),
																		new DefaultModuleCallAdaptor() {
																			public boolean inline() {
																				return true;
																			}

																			public boolean invoke(Intention intention, Predicate predicate) {
																				return ((astra.lang.Console) intention.getModule("Player","console")).println(
																					(java.lang.String) intention.evaluate(predicate.getTerm(0))
																				);
																			}
																		}
																	),
																	new Send("Player", new int[] {119,20,119,74},
																		new Performative("inform"),
																		Primitive.newPrimitive("main"),
																		new Predicate("game_completed", new Term[] {
																			new Variable(Type.STRING, "id"),
																			new Variable(Type.STRING, "myUri"),
																			Primitive.newPrimitive("win")
																		})
																	)
																}
															),
															new Block(
																"Player", new int[] {120,23,124,13},
																new Statement[] {
																	new ModuleCall("console",
																		"Player", new int[] {121,20,121,54},
																		new Predicate("println", new Term[] {
																			Primitive.newPrimitive("I lost the game")
																		}),
																		new DefaultModuleCallAdaptor() {
																			public boolean inline() {
																				return true;
																			}

																			public boolean invoke(Intention intention, Predicate predicate) {
																				return ((astra.lang.Console) intention.getModule("Player","console")).println(
																					(java.lang.String) intention.evaluate(predicate.getTerm(0))
																				);
																			}
																		}
																	),
																	new Send("Player", new int[] {122,20,122,75},
																		new Performative("inform"),
																		Primitive.newPrimitive("main"),
																		new Predicate("game_completed", new Term[] {
																			new Variable(Type.STRING, "id"),
																			new Variable(Type.STRING, "myUri"),
																			Primitive.newPrimitive("lose")
																		})
																	)
																}
															)
														)
													}
												)
											)
										}
									),
									new Block(
										"Player", new int[] {125,15,134,5},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {126,12,126,51},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Game ended in a draw")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ForEach(
												"Player", new int[] {127,12,130,9},
												new Predicate("agent_attributes", new Term[] {
													Primitive.newPrimitive("@id"),
													new Variable(Type.STRING, "myUri",false)
												}),
												new Block(
													"Player", new int[] {127,59,129,13},
													new Statement[] {
														new Send("Player", new int[] {128,16,128,71},
															new Performative("inform"),
															Primitive.newPrimitive("main"),
															new Predicate("game_completed", new Term[] {
																new Variable(Type.STRING, "id"),
																new Variable(Type.STRING, "myUri"),
																Primitive.newPrimitive("draw")
															})
														)
													}
												)
											)
										}
									)
								),
								new Subgoal(
									"Player", new int[] {132,8,134,5},
									new Goal(
										new Predicate("cleanup_game_state", new Term[] {
											new Variable(Type.STRING, "id"),
											new Variable(Type.STRING, "role"),
											new Variable(Type.STRING, "opponent")
										})
									)
								)
							}
						),
						new Block(
							"Player", new int[] {134,14,138,1},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {135,8,135,55},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Error processing game result")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Player", new int[] {136,8,137,5},
									new Goal(
										new Predicate("handle_api_error", new Term[] {
											new Variable(Type.STRING, "url")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {140,9,140,72},
			new GoalEvent('+',
				new Goal(
					new Predicate("cleanup_game_state", new Term[] {
						new Variable(Type.STRING, "id",false),
						new Variable(Type.STRING, "role",false),
						new Variable(Type.STRING, "opponent",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {140,71,163,5},
				new Statement[] {
					new BeliefUpdate('-',
						"Player", new int[] {142,8,163,5},
						new Predicate("game", new Term[] {
							new Variable(Type.STRING, "id"),
							new Variable(Type.STRING, "role"),
							new Variable(Type.STRING, "opponent")
						})
					),
					new BeliefUpdate('-',
						"Player", new int[] {143,8,163,5},
						new Predicate("turn", new Term[] {
							Primitive.newPrimitive(true)
						})
					),
					new ForEach(
						"Player", new int[] {146,8,163,5},
						new Predicate("move", new Term[] {
							new Variable(Type.STRING, "square",false),
							new Variable(Type.STRING, "player",false)
						}),
						new Block(
							"Player", new int[] {146,52,148,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {147,12,148,9},
									new Predicate("move", new Term[] {
										new Variable(Type.STRING, "square"),
										new Variable(Type.STRING, "player")
									})
								)
							}
						)
					),
					new ForEach(
						"Player", new int[] {149,8,163,5},
						new Predicate("free", new Term[] {
							new Variable(Type.STRING, "square",false)
						}),
						new Block(
							"Player", new int[] {149,37,151,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {150,12,151,9},
									new Predicate("free", new Term[] {
										new Variable(Type.STRING, "square")
									})
								)
							}
						)
					),
					new ForEach(
						"Player", new int[] {152,8,163,5},
						new Predicate("last_move", new Term[] {
							new Variable(Type.STRING, "move",false)
						}),
						new Block(
							"Player", new int[] {152,40,154,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {153,12,154,9},
									new Predicate("last_move", new Term[] {
										new Variable(Type.STRING, "move")
									})
								)
							}
						)
					),
					new BeliefUpdate('-',
						"Player", new int[] {157,8,163,5},
						new Predicate("api_error_count", new Term[] {
							new Variable(Type.INTEGER, "count",false)
						})
					),
					new BeliefUpdate('+',
						"Player", new int[] {158,8,163,5},
						new Predicate("api_error_count", new Term[] {
							Primitive.newPrimitive(0)
						})
					),
					new BeliefUpdate('-',
						"Player", new int[] {159,8,163,5},
						new Predicate("api_unavailable", new Term[] {
							Primitive.newPrimitive(true)
						})
					),
					new Subgoal(
						"Player", new int[] {161,8,163,5},
						new Goal(
							new Predicate("clear_knowledge", new Term[] {})
						)
					),
					new ModuleCall("console",
						"Player", new int[] {162,8,162,55},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Game state cleanup completed")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {165,9,165,95},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new Predicate("game", new Term[] {
				new Variable(Type.STRING, "id",false),
				new Variable(Type.STRING, "role",false),
				new Variable(Type.STRING, "opponent",false)
			}),
			new Block(
				"Player", new int[] {165,94,193,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {166,8,193,5},
						new Block(
							"Player", new int[] {166,12,189,9},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {167,12,167,69},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Processing board state for game: "),
											new Variable(Type.STRING, "id")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Player", new int[] {169,12,189,9},
									new Goal(
										new Predicate("form_actions", new Term[] {
											new Variable(Type.STRING, "url")
										})
									)
								),
								new Subgoal(
									"Player", new int[] {170,12,189,9},
									new Goal(
										new Predicate("link_actions", new Term[] {
											new Variable(Type.STRING, "url")
										})
									)
								),
								new ModuleCall("system",
									"Player", new int[] {172,12,172,29},
									new Predicate("sleep", new Term[] {
										Primitive.newPrimitive(1000)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return false;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.System) intention.getModule("Player","system")).sleep(
												(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Player", new int[] {174,12,189,9},
									new AND(
										new Predicate("link_actions", new Term[] {
											new Variable(Type.STRING, "link_url",false)
										}),
										new ModuleFormula("strings",
											new Predicate("contains", new Term[] {
												new Variable(Type.STRING, "link_url"),
												Primitive.newPrimitive("result")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).contains(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											)
									),
									new Block(
										"Player", new int[] {174,84,178,13},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {175,16,175,76},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Found result endpoint, checking result...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("knowledgeStoreGame",
												"Player", new int[] {176,16,176,68},
												new Predicate("getKnowledge", new Term[] {
													new Variable(Type.STRING, "link_url"),
													Primitive.newPrimitive("JSON-LD")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).getKnowledge(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new BeliefUpdate('+',
												"Player", new int[] {177,16,178,13},
												new Predicate("found_result", new Term[] {
													Primitive.newPrimitive(true)
												})
											)
										}
									),
									new Block(
										"Player", new int[] {178,19,189,9},
										new Statement[] {
											new If(
												"Player", new int[] {179,16,183,13},
												new Predicate("form_actions", new Term[] {
													new Variable(Type.STRING, "form_url",false),
													new Variable(Type.STRING, "method",false),
													new Variable(Type.LIST, "required",false)
												}),
												new Block(
													"Player", new int[] {179,80,181,17},
													new Statement[] {
														new Subgoal(
															"Player", new int[] {180,20,181,17},
															new Goal(
																new Predicate("execute_move", new Term[] {
																	new Variable(Type.STRING, "form_url"),
																	new Variable(Type.STRING, "method")
																})
															)
														)
													}
												)
											),
											new Send("Player", new int[] {182,16,182,50},
												new Performative("inform"),
												new Variable(Type.STRING, "opponent"),
												new Predicate("turn", new Term[] {
													Primitive.newPrimitive(true)
												})
											)
										}
									)
								),
								new BeliefUpdate('-',
									"Player", new int[] {185,12,189,9},
									new Predicate("turn", new Term[] {
										Primitive.newPrimitive(true)
									})
								),
								new Subgoal(
									"Player", new int[] {186,12,189,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								),
								new ModuleCall("console",
									"Player", new int[] {187,12,187,45},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Turn completed")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						),
						new Block(
							"Player", new int[] {189,18,193,5},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {190,12,190,59},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Error during turn processing")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Player", new int[] {191,12,192,9},
									new Goal(
										new Predicate("handle_api_error", new Term[] {
											new Variable(Type.STRING, "url")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {195,9,195,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("execute_move", new Term[] {
						new Variable(Type.STRING, "form_url",false),
						new Variable(Type.STRING, "method",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {195,56,216,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {196,8,216,5},
						new Block(
							"Player", new int[] {196,12,212,9},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {197,12,197,49},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Performing move...")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Player", new int[] {198,12,212,9},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).createObject(
												);
											}
										}
									)
								),
								new Query(
									"Player", new int[] {199,12,199,59},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "agentURL",false)
									})
								),
								new ModuleCall("builder",
									"Player", new int[] {200,12,200,58},
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
											return ((mams.JSONBuilder) intention.getModule("Player","builder")).addProperty(
												(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Player", new int[] {201,12,212,9},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new If(
									"Player", new int[] {203,12,212,9},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Player", new int[] {203,47,207,13},
										new Statement[] {
											new ScopedSubgoal(
												"Player", new int[] {204,16,207,13},
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
												"Player", new int[] {205,16,205,85},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Move response: "),
														new ModuleTerm("httpUtils", Type.STRING,
															new Predicate("bodyAsString", new Term[] {
																new Variable(new ObjectType(HttpResponse.class), "response")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new BeliefUpdate('+',
												"Player", new int[] {206,16,207,13},
												new Predicate("move_made", new Term[] {
													new Variable(Type.STRING, "form_url")
												})
											)
										}
									),
									new If(
										"Player", new int[] {207,19,212,9},
										new ModuleFormula("strings",
											new Predicate("equal", new Term[] {
												new Variable(Type.STRING, "method"),
												Primitive.newPrimitive("PUT")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).equal(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"Player", new int[] {207,53,211,13},
											new Statement[] {
												new ScopedSubgoal(
													"Player", new int[] {208,16,211,13},
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
													"Player", new int[] {209,16,209,85},
													new Predicate("println", new Term[] {
														Operator.newOperator('+',
															Primitive.newPrimitive("Move response: "),
															new ModuleTerm("httpUtils", Type.STRING,
																new Predicate("bodyAsString", new Term[] {
																	new Variable(new ObjectType(HttpResponse.class), "response")
																}),
																new ModuleTermAdaptor() {
																	public Object invoke(Intention intention, Predicate predicate) {
																		return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																			(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																		);
																	}
																	public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																		return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																			(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																		);
																	}
																}
															)
														)
													}),
													new DefaultModuleCallAdaptor() {
														public boolean inline() {
															return true;
														}

														public boolean invoke(Intention intention, Predicate predicate) {
															return ((astra.lang.Console) intention.getModule("Player","console")).println(
																(java.lang.String) intention.evaluate(predicate.getTerm(0))
															);
														}
													}
												),
												new BeliefUpdate('+',
													"Player", new int[] {210,16,211,13},
													new Predicate("move_made", new Term[] {
														new Variable(Type.STRING, "form_url")
													})
												)
											}
										)
									)
								)
							}
						),
						new Block(
							"Player", new int[] {212,18,216,5},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {213,12,213,54},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Failed to perform move!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Subgoal(
									"Player", new int[] {214,12,215,9},
									new Goal(
										new Predicate("handle_api_error", new Term[] {
											new Variable(Type.STRING, "form_url")
										})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {218,9,218,47},
			new ModuleEvent("knowledgeStoreGame",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Player","knowledgeStoreGame")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {218,46,222,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {219,8,219,60},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Processed information from "),
								new Variable(Type.STRING, "url")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Player", new int[] {220,8,222,5},
						new Goal(
							new Predicate("form_actions", new Term[] {
								new Variable(Type.STRING, "url")
							})
						)
					),
					new Subgoal(
						"Player", new int[] {221,8,222,5},
						new Goal(
							new Predicate("link_actions", new Term[] {
								new Variable(Type.STRING, "url")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {224,9,227,36},
			new BeliefEvent('+',
				new Predicate("form_actions", new Term[] {
					new Variable(Type.STRING, "form_url",false),
					new Variable(Type.STRING, "http_method",false),
					new Variable(Type.LIST, "required_actions",false)
				})
			),
			new AND(
				new NOT(
					new Predicate("game", new Term[] {
						new Variable(Type.STRING, "id",false),
						new Variable(Type.STRING, "role",false),
						new Variable(Type.STRING, "opponent",false)
					})
				),
				new AND(
					new ModuleFormula("strings",
						new Predicate("endsWith", new Term[] {
							new Variable(Type.STRING, "form_url"),
							Primitive.newPrimitive("register")
						}),
					new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).endsWith(
									(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
									(java.lang.String) visitor.evaluate(predicate.getTerm(1))
								);
						}
					}
						),
					new Predicate("http_fail_count", new Term[] {
						new Variable(Type.INTEGER, "count",false)
					})
				)
			),
			new Block(
				"Player", new int[] {227,35,259,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {229,8,259,5},
						new Block(
							"Player", new int[] {229,12,253,9},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {230,12,230,75},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Attempting to register with URL: "),
											new Variable(Type.STRING, "form_url")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Player", new int[] {231,12,253,9},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).createObject(
												);
											}
										}
									)
								),
								new ForEach(
									"Player", new int[] {233,12,253,9},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "uri",false)
									}),
									new Block(
										"Player", new int[] {233,57,236,13},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {234,16,234,58},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Using agent URI: "),
														new Variable(Type.STRING, "uri")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("builder",
												"Player", new int[] {235,16,235,57},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													Primitive.newPrimitive("@id"),
													new Variable(Type.STRING, "uri")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((mams.JSONBuilder) intention.getModule("Player","builder")).addProperty(
															(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1)),
															(java.lang.String) intention.evaluate(predicate.getTerm(2))
														);
													}
												}
											)
										}
									)
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Player", new int[] {238,12,253,9},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Player", new int[] {239,12,239,55},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Request body: "),
											new Variable(Type.STRING, "bodyStr")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Player", new int[] {241,12,253,9},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "http_method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Player", new int[] {241,52,245,13},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {242,16,242,58},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending POST request...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ScopedSubgoal(
												"Player", new int[] {243,16,245,13},
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
												"Player", new int[] {244,16,244,93},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Registration response: "),
														new ModuleTerm("httpUtils", Type.STRING,
															new Predicate("bodyAsString", new Term[] {
																new Variable(new ObjectType(HttpResponse.class), "response")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new Block(
										"Player", new int[] {245,19,253,9},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {246,16,246,57},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending PUT request...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ScopedSubgoal(
												"Player", new int[] {247,16,249,13},
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
												"Player", new int[] {248,16,248,93},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Registration response: "),
														new ModuleTerm("httpUtils", Type.STRING,
															new Predicate("bodyAsString", new Term[] {
																new Variable(new ObjectType(HttpResponse.class), "response")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new Subgoal(
									"Player", new int[] {251,12,253,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								)
							}
						),
						new Block(
							"Player", new int[] {253,18,259,5},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {254,12,254,74},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Registration failed. Attempt: "),
											new Brackets(
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "count"),
													Primitive.newPrimitive(1)
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new BeliefUpdate('-',
									"Player", new int[] {255,12,258,9},
									new Predicate("http_fail_count", new Term[] {
										new Variable(Type.INTEGER, "count")
									})
								),
								new BeliefUpdate('+',
									"Player", new int[] {256,12,258,9},
									new Predicate("http_fail_count", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new BeliefUpdate('+',
									"Player", new int[] {257,12,258,9},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "form_url"),
										new Variable(Type.STRING, "http_method"),
										new Variable(Type.LIST, "required_actions")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {261,9,264,36},
			new BeliefEvent('+',
				new Predicate("form_actions", new Term[] {
					new Variable(Type.STRING, "form_url",false),
					new Variable(Type.STRING, "http_method",false),
					new Variable(Type.LIST, "required_actions",false)
				})
			),
			new AND(
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				}),
				new AND(
					new ModuleFormula("strings",
						new Predicate("endsWith", new Term[] {
							new Variable(Type.STRING, "form_url"),
							Primitive.newPrimitive("register")
						}),
					new ModuleFormulaAdaptor() {
							public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
								return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).endsWith(
									(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
									(java.lang.String) visitor.evaluate(predicate.getTerm(1))
								);
						}
					}
						),
					new Predicate("http_fail_count", new Term[] {
						new Variable(Type.INTEGER, "count",false)
					})
				)
			),
			new Block(
				"Player", new int[] {264,35,296,5},
				new Statement[] {
					new TryRecover(
						"Player", new int[] {266,8,296,5},
						new Block(
							"Player", new int[] {266,12,290,9},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {267,12,267,75},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Attempting to register with URL: "),
											new Variable(Type.STRING, "form_url")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Player", new int[] {268,12,290,9},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).createObject(
												);
											}
										}
									)
								),
								new ForEach(
									"Player", new int[] {270,12,290,9},
									new Predicate("agent_attributes", new Term[] {
										Primitive.newPrimitive("@id"),
										new Variable(Type.STRING, "uri",false)
									}),
									new Block(
										"Player", new int[] {270,57,273,13},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {271,16,271,58},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Using agent URI: "),
														new Variable(Type.STRING, "uri")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("builder",
												"Player", new int[] {272,16,272,57},
												new Predicate("addProperty", new Term[] {
													new Variable(new ObjectType(JsonNode.class), "bodyJson"),
													Primitive.newPrimitive("@id"),
													new Variable(Type.STRING, "uri")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((mams.JSONBuilder) intention.getModule("Player","builder")).addProperty(
															(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1)),
															(java.lang.String) intention.evaluate(predicate.getTerm(2))
														);
													}
												}
											)
										}
									)
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Player", new int[] {275,12,290,9},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Player", new int[] {276,12,276,55},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Request body: "),
											new Variable(Type.STRING, "bodyStr")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Player", new int[] {278,12,290,9},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "http_method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Player", new int[] {278,52,282,13},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {279,16,279,58},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending POST request...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ScopedSubgoal(
												"Player", new int[] {280,16,282,13},
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
												"Player", new int[] {281,16,281,93},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Registration response: "),
														new ModuleTerm("httpUtils", Type.STRING,
															new Predicate("bodyAsString", new Term[] {
																new Variable(new ObjectType(HttpResponse.class), "response")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new Block(
										"Player", new int[] {282,19,290,9},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {283,16,283,57},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending PUT request...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ScopedSubgoal(
												"Player", new int[] {284,16,286,13},
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
												"Player", new int[] {285,16,285,93},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Registration response: "),
														new ModuleTerm("httpUtils", Type.STRING,
															new Predicate("bodyAsString", new Term[] {
																new Variable(new ObjectType(HttpResponse.class), "response")
															}),
															new ModuleTermAdaptor() {
																public Object invoke(Intention intention, Predicate predicate) {
																	return ((mams.HttpUtils) intention.getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
																	);
																}
																public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((mams.HttpUtils) visitor.agent().getModule("Player","httpUtils")).bodyAsString(
																		(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new Subgoal(
									"Player", new int[] {288,12,290,9},
									new Goal(
										new Predicate("clear_knowledge", new Term[] {})
									)
								)
							}
						),
						new Block(
							"Player", new int[] {290,18,296,5},
							new Statement[] {
								new ModuleCall("console",
									"Player", new int[] {291,12,291,74},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Registration failed. Attempt: "),
											new Brackets(
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "count"),
													Primitive.newPrimitive(1)
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new BeliefUpdate('-',
									"Player", new int[] {292,12,295,9},
									new Predicate("http_fail_count", new Term[] {
										new Variable(Type.INTEGER, "count")
									})
								),
								new BeliefUpdate('+',
									"Player", new int[] {293,12,295,9},
									new Predicate("http_fail_count", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new BeliefUpdate('+',
									"Player", new int[] {294,12,295,9},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "form_url"),
										new Variable(Type.STRING, "http_method"),
										new Variable(Type.LIST, "required_actions")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {299,9,299,72},
			new BeliefEvent('+',
				new Predicate("http_fail_count", new Term[] {
					new Variable(Type.INTEGER, "i",false)
				})
			),
			new AND(
				new Predicate("failure_threshold", new Term[] {
					new Variable(Type.INTEGER, "j",false)
				}),
				new BracketFormula(
					new Comparison(">=",
						new Variable(Type.INTEGER, "i"),
						new Variable(Type.INTEGER, "j")
					)
				)
			),
			new Block(
				"Player", new int[] {299,71,302,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {300,8,300,59},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Too many failures! Shutting down")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Player", new int[] {301,8,301,21},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Player","system")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {303,9,303,56},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("reregister", new Term[] {})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {303,55,317,1},
				new Statement[] {
					new ForEach(
						"Player", new int[] {304,4,317,1},
						new Predicate("api_index_url", new Term[] {
							new Variable(Type.STRING, "url",false)
						}),
						new Block(
							"Player", new int[] {304,39,316,5},
							new Statement[] {
								new TryRecover(
									"Player", new int[] {305,8,316,5},
									new Block(
										"Player", new int[] {305,12,313,9},
										new Statement[] {
											new Declaration(
												new Variable(new ObjectType(JsonNode.class), "bodyJson"),
												"Player", new int[] {306,12,313,9},
												new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
													new Predicate("createObject", new Term[] {}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((mams.JSONBuilder) intention.getModule("Player","builder")).createObject(
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).createObject(
															);
														}
													}
												)
											),
											new ForEach(
												"Player", new int[] {307,12,313,9},
												new Predicate("agent_attributes", new Term[] {
													Primitive.newPrimitive("@id"),
													new Variable(Type.STRING, "uri",false)
												}),
												new Block(
													"Player", new int[] {307,57,309,13},
													new Statement[] {
														new ModuleCall("builder",
															"Player", new int[] {308,16,308,57},
															new Predicate("addProperty", new Term[] {
																new Variable(new ObjectType(JsonNode.class), "bodyJson"),
																Primitive.newPrimitive("@id"),
																new Variable(Type.STRING, "uri")
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((mams.JSONBuilder) intention.getModule("Player","builder")).addProperty(
																		(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(1)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(2))
																	);
																}
															}
														)
													}
												)
											),
											new Declaration(
												new Variable(Type.STRING, "bodyStr"),
												"Player", new int[] {310,12,313,9},
												new ModuleTerm("builder", Type.STRING,
													new Predicate("toJsonString", new Term[] {
														new Variable(new ObjectType(JsonNode.class), "bodyJson")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((mams.JSONBuilder) intention.getModule("Player","builder")).toJsonString(
																(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((mams.JSONBuilder) visitor.agent().getModule("Player","builder")).toJsonString(
																(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
															);
														}
													}
												)
											),
											new ScopedSubgoal(
												"Player", new int[] {311,12,313,9},
												"MAMSAgent",
												new Goal(
													new Predicate("post", new Term[] {
														Operator.newOperator('+',
															new Variable(Type.STRING, "url"),
															Primitive.newPrimitive("register")
														),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new ModuleCall("console",
												"Player", new int[] {312,12,312,59},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Re-registered for next match")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new Block(
										"Player", new int[] {313,18,316,5},
										new Statement[] {
											new ModuleCall("console",
												"Player", new int[] {314,12,314,53},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Failed to re-register!")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Player","console")).println(
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
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {319,9,319,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {319,29,327,5},
				new Statement[] {
					new ModuleCall("knowledgeStoreGame",
						"Player", new int[] {320,8,320,34},
						new Predicate("clear", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).clear(
								);
							}
						}
					),
					new ForEach(
						"Player", new int[] {321,8,327,5},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Player", new int[] {321,81,323,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {322,12,323,9},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "anyForm"),
										new Variable(Type.STRING, "method_name"),
										new Variable(Type.LIST, "any_list")
									})
								)
							}
						)
					),
					new ForEach(
						"Player", new int[] {324,8,327,5},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Player", new int[] {324,46,326,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {325,12,326,9},
									new Predicate("link_actions", new Term[] {
										new Variable(Type.STRING, "anyLink")
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {329,9,329,89},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {329,88,345,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {330,8,330,51},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("===Game setting check===")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ForEach(
						"Player", new int[] {331,8,345,5},
						new Predicate("game", new Term[] {
							new Variable(Type.STRING, "old_id",false),
							new Variable(Type.STRING, "old_role",false),
							new Variable(Type.STRING, "old_opponent",false)
						}),
						new Block(
							"Player", new int[] {331,75,333,9},
							new Statement[] {
								new BeliefUpdate('-',
									"Player", new int[] {332,12,333,9},
									new Predicate("game", new Term[] {
										new Variable(Type.STRING, "old_id"),
										new Variable(Type.STRING, "old_role"),
										new Variable(Type.STRING, "old_opponent")
									})
								)
							}
						)
					),
					new BeliefUpdate('-',
						"Player", new int[] {334,8,345,5},
						new Predicate("turn", new Term[] {
							Primitive.newPrimitive(true)
						})
					),
					new Subgoal(
						"Player", new int[] {335,8,345,5},
						new Goal(
							new Predicate("clear_knowledge", new Term[] {})
						)
					),
					new ModuleCall("console",
						"Player", new int[] {337,8,337,107},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("I've got the game "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "id"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" with the role "),
										Operator.newOperator('+',
											new Variable(Type.STRING, "role"),
											Operator.newOperator('+',
												Primitive.newPrimitive(" and opponent "),
												new Variable(Type.STRING, "opponent")
											)
										)
									)
								)
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Player", new int[] {339,8,345,5},
						new Predicate("game", new Term[] {
							new Variable(Type.STRING, "id"),
							new Variable(Type.STRING, "role"),
							new Variable(Type.STRING, "opponent")
						})
					),
					new If(
						"Player", new int[] {341,8,345,5},
						new ModuleFormula("strings",
							new Predicate("contains", new Term[] {
								new Variable(Type.STRING, "role"),
								Primitive.newPrimitive("XPlayerRole")
							}),
						new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Strings) visitor.agent().getModule("Player","strings")).contains(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
										(java.lang.String) visitor.evaluate(predicate.getTerm(1))
									);
							}
						}
							),
						new Block(
							"Player", new int[] {341,50,344,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {342,12,344,9},
									new Predicate("turn", new Term[] {
										Primitive.newPrimitive(true)
									})
								),
								new ModuleCall("console",
									"Player", new int[] {343,12,343,55},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("It's my turn as X player")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Player","console")).println(
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
			"Player", new int[] {347,9,347,54},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {347,53,351,5},
				new Statement[] {
					new If(
						"Player", new int[] {348,8,351,5},
						new AND(
							new Predicate("game", new Term[] {
								new Variable(Type.STRING, "id",false),
								new Variable(Type.STRING, "role",false),
								new Variable(Type.STRING, "opponent",false)
							}),
							new Predicate("api_index_url", new Term[] {
								new Variable(Type.STRING, "url",false)
							})
						),
						new Block(
							"Player", new int[] {348,86,350,9},
							new Statement[] {
								new BeliefUpdate('+',
									"Player", new int[] {349,12,350,9},
									new Predicate("turn", new Term[] {
										Primitive.newPrimitive(true)
									})
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {353,9,353,98},
			new BeliefEvent('+',
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			new AND(
				new Predicate("game", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "role",false),
					new Variable(Type.STRING, "opponent",false)
				}),
				new Predicate("api_index_url", new Term[] {
					new Variable(Type.STRING, "url",false)
				})
			),
			new Block(
				"Player", new int[] {353,97,356,5},
				new Statement[] {
					new ModuleCall("console",
						"Player", new int[] {354,8,354,66},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Fetching board state for game ID: "),
								new Variable(Type.STRING, "id")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Player","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("knowledgeStoreGame",
						"Player", new int[] {355,8,355,71},
						new Predicate("getKnowledge", new Term[] {
							Operator.newOperator('+',
								new Variable(Type.STRING, "url"),
								Operator.newOperator('+',
									Primitive.newPrimitive("Board/"),
									new Variable(Type.STRING, "id")
								)
							),
							Primitive.newPrimitive("JSON-LD")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Player","knowledgeStoreGame")).getKnowledge(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Player", new int[] {358,9,358,22},
			new BeliefEvent('-',
				new Predicate("turn", new Term[] {
					Primitive.newPrimitive(true)
				})
			),
			Predicate.TRUE,
			new Block(
				"Player", new int[] {358,21,360,5},
				new Statement[] {
					new Subgoal(
						"Player", new int[] {359,8,360,5},
						new Goal(
							new Predicate("clear_knowledge", new Term[] {})
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("http_fail_count", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("failure_threshold", new Term[] {
				Primitive.newPrimitive(10)
			})
		);
		agent.initialize(
			new Predicate("api_error_count", new Term[] {
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("api_unavailable", new Term[] {
				Primitive.newPrimitive(false)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("knowledgeStoreGame",astra.jena.KnowledgeStore.class,agent);
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
			astra.core.Agent agent = new Player().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Player");
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

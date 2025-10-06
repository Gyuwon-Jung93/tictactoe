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

public class Main extends ASTRAClass {
	public Main() {
		setParents(new Class[] {Shared.class});
		addRule(new Rule(
			"Main", new int[] {41,8,41,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("main", new Term[] {
						new Variable(Type.LIST, "l",false)
					})
				)
			),
			new Predicate("api_index_url", new Term[] {
				new Variable(Type.STRING, "game_url",false)
			}),
			new Block(
				"Main", new int[] {41,56,61,4},
				new Statement[] {
					new ModuleCall("messaging",
						"Main", new int[] {42,7,42,76},
						new Predicate("installService", new Term[] {
							Primitive.newPrimitive("mams"),
							Primitive.newPrimitive("mams.messaging.MAMSMessageService")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Messaging) intention.getModule("Main","messaging")).installService(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ScopedSubgoal(
						"Main", new int[] {44,7,61,4},
						"MAMSAgent",
						new Goal(
							new Predicate("setup", new Term[] {})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {45,7,61,4},
						"MAMSAgent",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("base")
							})
						)
					),
					new ScopedSubgoal(
						"Main", new int[] {46,7,61,4},
						"IntegratedInbox",
						new Goal(
							new Predicate("created", new Term[] {
								Primitive.newPrimitive("inbox")
							})
						)
					),
					new ModuleCall("system",
						"Main", new int[] {48,7,48,45},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("Better"),
							Primitive.newPrimitive("Player")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {49,7,49,47},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("Better"),
							new ListTerm(new Term[] {
								new Variable(Type.STRING, "game_url")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {50,7,50,47},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("Opponent"),
							Primitive.newPrimitive("Player")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {51,7,51,49},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("Opponent"),
							new ListTerm(new Term[] {
								new Variable(Type.STRING, "game_url")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {52,7,52,48},
						new Predicate("createAgent", new Term[] {
							Primitive.newPrimitive("NewPlayer"),
							Primitive.newPrimitive("Player")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).createAgent(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(java.lang.String) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {53,7,53,50},
						new Predicate("setMainGoal", new Term[] {
							Primitive.newPrimitive("NewPlayer"),
							new ListTerm(new Term[] {
								new Variable(Type.STRING, "game_url")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).setMainGoal(
									(java.lang.String) intention.evaluate(predicate.getTerm(0)),
									(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
								);
							}
						}
					),
					new BeliefUpdate('+',
						"Main", new int[] {55,7,61,4},
						new Predicate("tournament_score", new Term[] {
							Primitive.newPrimitive("Better"),
							Primitive.newPrimitive(0)
						})
					),
					new BeliefUpdate('+',
						"Main", new int[] {56,7,61,4},
						new Predicate("tournament_score", new Term[] {
							Primitive.newPrimitive("Opponent"),
							Primitive.newPrimitive(0)
						})
					),
					new BeliefUpdate('+',
						"Main", new int[] {57,7,61,4},
						new Predicate("tournament_score", new Term[] {
							Primitive.newPrimitive("NewPlayer"),
							Primitive.newPrimitive(0)
						})
					),
					new ModuleCall("system",
						"Main", new int[] {59,7,59,24},
						new Predicate("sleep", new Term[] {
							Primitive.newPrimitive(2000)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).sleep(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"Main", new int[] {60,7,61,4},
						new Goal(
							new Predicate("start_tournament", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {63,8,63,30},
			new GoalEvent('+',
				new Goal(
					new Predicate("start_tournament", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {63,29,75,4},
				new Statement[] {
					new ModuleCall("console",
						"Main", new int[] {64,7,64,53},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("=== Tournament Starting ===")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ForEach(
						"Main", new int[] {65,7,75,4},
						new Predicate("match_number", new Term[] {
							new Variable(Type.INTEGER, "num",false)
						}),
						new Block(
							"Main", new int[] {65,38,73,8},
							new Statement[] {
								new If(
									"Main", new int[] {66,11,73,8},
									new Comparison("==",
										new Variable(Type.INTEGER, "num"),
										Primitive.newPrimitive(1)
									),
									new Block(
										"Main", new int[] {66,23,68,12},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {67,15,68,12},
												new Predicate("current_pair", new Term[] {
													Primitive.newPrimitive("Better"),
													Primitive.newPrimitive("Opponent")
												})
											)
										}
									),
									new If(
										"Main", new int[] {68,18,73,8},
										new Comparison("==",
											new Variable(Type.INTEGER, "num"),
											Primitive.newPrimitive(2)
										),
										new Block(
											"Main", new int[] {68,30,70,12},
											new Statement[] {
												new BeliefUpdate('+',
													"Main", new int[] {69,15,70,12},
													new Predicate("current_pair", new Term[] {
														Primitive.newPrimitive("Better"),
														Primitive.newPrimitive("NewPlayer")
													})
												)
											}
										),
										new If(
											"Main", new int[] {70,18,73,8},
											new Comparison("==",
												new Variable(Type.INTEGER, "num"),
												Primitive.newPrimitive(3)
											),
											new Block(
												"Main", new int[] {70,30,72,12},
												new Statement[] {
													new BeliefUpdate('+',
														"Main", new int[] {71,15,72,12},
														new Predicate("current_pair", new Term[] {
															Primitive.newPrimitive("Opponent"),
															Primitive.newPrimitive("NewPlayer")
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
					new Subgoal(
						"Main", new int[] {74,7,75,4},
						new Goal(
							new Predicate("setup_current_match", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {77,8,77,33},
			new GoalEvent('+',
				new Goal(
					new Predicate("setup_current_match", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {77,32,118,1},
				new Statement[] {
					new ForEach(
						"Main", new int[] {78,4,118,1},
						new Predicate("current_pair", new Term[] {
							new Variable(Type.STRING, "player1",false),
							new Variable(Type.STRING, "player2",false)
						}),
						new Block(
							"Main", new int[] {78,58,117,5},
							new Statement[] {
								new If(
									"Main", new int[] {79,8,117,5},
									new AND(
										new NOT(
											new Predicate("player_timeout", new Term[] {
												new Variable(Type.STRING, "player1")
											})
										),
										new NOT(
											new Predicate("player_timeout", new Term[] {
												new Variable(Type.STRING, "player2")
											})
										)
									),
									new Block(
										"Main", new int[] {79,64,105,9},
										new Statement[] {
											new ModuleCall("system",
												"Main", new int[] {81,12,81,29},
												new Predicate("sleep", new Term[] {
													Primitive.newPrimitive(1000)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return false;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","system")).sleep(
															(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Send("Main", new int[] {84,12,84,74},
												new Performative("inform"),
												Operator.newOperator('+',
													Primitive.newPrimitive("http://127.0.0.1:9000/"),
													new Variable(Type.STRING, "player1")
												),
												new Predicate("reregister", new Term[] {})
											),
											new Send("Main", new int[] {85,12,85,74},
												new Performative("inform"),
												Operator.newOperator('+',
													Primitive.newPrimitive("http://127.0.0.1:9000/"),
													new Variable(Type.STRING, "player2")
												),
												new Predicate("reregister", new Term[] {})
											),
											new ModuleCall("system",
												"Main", new int[] {87,12,87,29},
												new Predicate("sleep", new Term[] {
													Primitive.newPrimitive(2000)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return false;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","system")).sleep(
															(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ForEach(
												"Main", new int[] {89,12,105,9},
												new Predicate("match_number", new Term[] {
													new Variable(Type.INTEGER, "num",false)
												}),
												new Block(
													"Main", new int[] {89,43,103,13},
													new Statement[] {
														new If(
															"Main", new int[] {90,16,103,13},
															new Comparison("==",
																new Variable(Type.INTEGER, "num"),
																Primitive.newPrimitive(1)
															),
															new Block(
																"Main", new int[] {90,28,94,17},
																new Statement[] {
																	new BeliefUpdate('+',
																		"Main", new int[] {91,20,94,17},
																		new Predicate("player", new Term[] {
																			Primitive.newPrimitive("ttt:XPlayerRole"),
																			Primitive.newPrimitive("http://127.0.0.1:9000/Better")
																		})
																	),
																	new BeliefUpdate('+',
																		"Main", new int[] {92,20,94,17},
																		new Predicate("player", new Term[] {
																			Primitive.newPrimitive("ttt:OPlayerRole"),
																			Primitive.newPrimitive("http://127.0.0.1:9000/Opponent")
																		})
																	),
																	new ModuleCall("console",
																		"Main", new int[] {93,20,93,72},
																		new Predicate("println", new Term[] {
																			Primitive.newPrimitive("Match 1: Better(X) vs Opponent(O)")
																		}),
																		new DefaultModuleCallAdaptor() {
																			public boolean inline() {
																				return true;
																			}

																			public boolean invoke(Intention intention, Predicate predicate) {
																				return ((astra.lang.Console) intention.getModule("Main","console")).println(
																					(java.lang.String) intention.evaluate(predicate.getTerm(0))
																				);
																			}
																		}
																	)
																}
															),
															new If(
																"Main", new int[] {94,23,103,13},
																new Comparison("==",
																	new Variable(Type.INTEGER, "num"),
																	Primitive.newPrimitive(2)
																),
																new Block(
																	"Main", new int[] {94,35,98,17},
																	new Statement[] {
																		new BeliefUpdate('+',
																			"Main", new int[] {95,20,98,17},
																			new Predicate("player", new Term[] {
																				Primitive.newPrimitive("ttt:XPlayerRole"),
																				Primitive.newPrimitive("http://127.0.0.1:9000/NewPlayer")
																			})
																		),
																		new BeliefUpdate('+',
																			"Main", new int[] {96,20,98,17},
																			new Predicate("player", new Term[] {
																				Primitive.newPrimitive("ttt:OPlayerRole"),
																				Primitive.newPrimitive("http://127.0.0.1:9000/Better")
																			})
																		),
																		new ModuleCall("console",
																			"Main", new int[] {97,20,97,73},
																			new Predicate("println", new Term[] {
																				Primitive.newPrimitive("Match 2: NewPlayer(X) vs Better(O)")
																			}),
																			new DefaultModuleCallAdaptor() {
																				public boolean inline() {
																					return true;
																				}

																				public boolean invoke(Intention intention, Predicate predicate) {
																					return ((astra.lang.Console) intention.getModule("Main","console")).println(
																						(java.lang.String) intention.evaluate(predicate.getTerm(0))
																					);
																				}
																			}
																		)
																	}
																),
																new If(
																	"Main", new int[] {98,23,103,13},
																	new Comparison("==",
																		new Variable(Type.INTEGER, "num"),
																		Primitive.newPrimitive(3)
																	),
																	new Block(
																		"Main", new int[] {98,35,102,17},
																		new Statement[] {
																			new BeliefUpdate('+',
																				"Main", new int[] {99,20,102,17},
																				new Predicate("player", new Term[] {
																					Primitive.newPrimitive("ttt:XPlayerRole"),
																					Primitive.newPrimitive("http://127.0.0.1:9000/Opponent")
																				})
																			),
																			new BeliefUpdate('+',
																				"Main", new int[] {100,20,102,17},
																				new Predicate("player", new Term[] {
																					Primitive.newPrimitive("ttt:OPlayerRole"),
																					Primitive.newPrimitive("http://127.0.0.1:9000/NewPlayer")
																				})
																			),
																			new ModuleCall("console",
																				"Main", new int[] {101,20,101,75},
																				new Predicate("println", new Term[] {
																					Primitive.newPrimitive("Match 3: Opponent(X) vs NewPlayer(O)")
																				}),
																				new DefaultModuleCallAdaptor() {
																					public boolean inline() {
																						return true;
																					}

																					public boolean invoke(Intention intention, Predicate predicate) {
																						return ((astra.lang.Console) intention.getModule("Main","console")).println(
																							(java.lang.String) intention.evaluate(predicate.getTerm(0))
																						);
																					}
																				}
																			)
																		}
																	)
																)
															)
														)
													}
												)
											),
											new Subgoal(
												"Main", new int[] {104,12,105,9},
												new Goal(
													new Predicate("game", new Term[] {})
												)
											)
										}
									),
									new Block(
										"Main", new int[] {105,15,117,5},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {106,12,106,74},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Skipping match due to unavailable player(s)")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ForEach(
												"Main", new int[] {107,12,116,9},
												new Predicate("match_number", new Term[] {
													new Variable(Type.INTEGER, "num",false)
												}),
												new Block(
													"Main", new int[] {107,43,115,13},
													new Statement[] {
														new BeliefUpdate('-',
															"Main", new int[] {108,16,115,13},
															new Predicate("match_number", new Term[] {
																new Variable(Type.INTEGER, "num")
															})
														),
														new If(
															"Main", new int[] {109,16,115,13},
															new Comparison("<",
																new Variable(Type.INTEGER, "num"),
																Primitive.newPrimitive(3)
															),
															new Block(
																"Main", new int[] {109,27,112,17},
																new Statement[] {
																	new BeliefUpdate('+',
																		"Main", new int[] {110,20,112,17},
																		new Predicate("match_number", new Term[] {
																			Operator.newOperator('+',
																				new Variable(Type.INTEGER, "num"),
																				Primitive.newPrimitive(1)
																			)
																		})
																	),
																	new Subgoal(
																		"Main", new int[] {111,20,112,17},
																		new Goal(
																			new Predicate("start_tournament", new Term[] {})
																		)
																	)
																}
															),
															new Block(
																"Main", new int[] {112,23,115,13},
																new Statement[] {
																	new Subgoal(
																		"Main", new int[] {113,20,114,17},
																		new Goal(
																			new Predicate("print_tournament_results", new Term[] {})
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
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {120,8,120,51},
			new GoalEvent('+',
				new Goal(
					new Predicate("game", new Term[] {})
				)
			),
			new Predicate("api_index_url", new Term[] {
				new Variable(Type.STRING, "game_url",false)
			}),
			new Block(
				"Main", new int[] {120,50,126,4},
				new Statement[] {
					new TryRecover(
						"Main", new int[] {121,7,126,4},
						new Block(
							"Main", new int[] {121,11,123,8},
							new Statement[] {
								new ModuleCall("knowledgeStore",
									"Main", new int[] {122,11,122,71},
									new Predicate("getKnowledge", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.STRING, "game_url"),
											Primitive.newPrimitive("players")
										),
										Primitive.newPrimitive("JSON-LD")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledge(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(java.lang.String) intention.evaluate(predicate.getTerm(1))
											);
										}
									}
								)
							}
						),
						new Block(
							"Main", new int[] {123,17,126,4},
							new Statement[] {
								new Subgoal(
									"Main", new int[] {124,11,125,8},
									new Goal(
										new Predicate("handle_api_error", new Term[] {
											Operator.newOperator('+',
												new Variable(Type.STRING, "game_url"),
												Primitive.newPrimitive("players")
											)
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
			"Main", new int[] {128,8,128,45},
			new GoalEvent('+',
				new Goal(
					new Predicate("handle_api_error", new Term[] {
						new Variable(Type.STRING, "endpoint",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {128,44,143,4},
				new Statement[] {
					new ForEach(
						"Main", new int[] {129,7,143,4},
						new Predicate("api_error_count", new Term[] {
							new Variable(Type.INTEGER, "count",false)
						}),
						new Block(
							"Main", new int[] {129,43,142,8},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {130,11,142,8},
									new Predicate("api_error_count", new Term[] {
										new Variable(Type.INTEGER, "count")
									})
								),
								new BeliefUpdate('+',
									"Main", new int[] {131,11,142,8},
									new Predicate("api_error_count", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "count"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new If(
									"Main", new int[] {133,11,142,8},
									new Comparison(">=",
										new Variable(Type.INTEGER, "count"),
										Primitive.newPrimitive(5)
									),
									new Block(
										"Main", new int[] {133,25,137,12},
										new Statement[] {
											new BeliefUpdate('+',
												"Main", new int[] {134,15,137,12},
												new Predicate("api_unavailable", new Term[] {
													Primitive.newPrimitive(true)
												})
											),
											new ModuleCall("console",
												"Main", new int[] {135,15,135,69},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("API unavailable - ending tournament")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Subgoal(
												"Main", new int[] {136,15,137,12},
												new Goal(
													new Predicate("print_tournament_results", new Term[] {})
												)
											)
										}
									),
									new Block(
										"Main", new int[] {137,18,142,8},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {138,15,138,78},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("API error "),
														Operator.newOperator('+',
															new Brackets(
																Operator.newOperator('+',
																	new Variable(Type.INTEGER, "count"),
																	Primitive.newPrimitive(1)
																)
															),
															Primitive.newPrimitive("/5 - retrying...")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("system",
												"Main", new int[] {139,15,139,32},
												new Predicate("sleep", new Term[] {
													Primitive.newPrimitive(1000)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return false;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.System) intention.getModule("Main","system")).sleep(
															(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new Subgoal(
												"Main", new int[] {140,15,141,12},
												new Goal(
													new Predicate("game", new Term[] {})
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
			"Main", new int[] {145,8,145,77},
			new ModuleEvent("knowledgeStore",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Main","knowledgeStore")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "url"),
					Primitive.newPrimitive("players")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {145,76,174,1},
				new Statement[] {
					new ForEach(
						"Main", new int[] {146,4,174,1},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "oldForm",false),
							new Variable(Type.STRING, "oldMethod",false),
							new Variable(Type.LIST, "oldList",false)
						}),
						new Block(
							"Main", new int[] {146,74,148,5},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {147,8,148,5},
									new Predicate("form_actions", new Term[] {
										new Variable(Type.STRING, "oldForm"),
										new Variable(Type.STRING, "oldMethod"),
										new Variable(Type.LIST, "oldList")
									})
								)
							}
						)
					),
					new ForEach(
						"Main", new int[] {149,4,174,1},
						new Predicate("player", new Term[] {
							new Variable(Type.STRING, "oldRole",false),
							new Variable(Type.STRING, "oldUrl",false)
						}),
						new Block(
							"Main", new int[] {149,51,151,5},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {150,8,151,5},
									new Predicate("player", new Term[] {
										new Variable(Type.STRING, "oldRole"),
										new Variable(Type.STRING, "oldUrl")
									})
								)
							}
						)
					),
					new Declaration(
						new Variable(Type.STRING, "registerGameUrl"),
						"Main", new int[] {154,4,174,1},
						Primitive.newPrimitive("http://localhost:8083/registerGame")
					),
					new Declaration(
						new Variable(Type.STRING, "method"),
						"Main", new int[] {155,4,174,1},
						Primitive.newPrimitive("POST")
					),
					new Declaration(
						new Variable(Type.LIST, "required"),
						"Main", new int[] {156,4,174,1},
						new ListTerm(new Term[] {
							Primitive.newPrimitive("ttt:XPlayerRole"),
							Primitive.newPrimitive("ttt:OPlayerRole")
						})
					),
					new BeliefUpdate('+',
						"Main", new int[] {157,4,174,1},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "registerGameUrl"),
							new Variable(Type.STRING, "method"),
							new Variable(Type.LIST, "required")
						})
					),
					new ForEach(
						"Main", new int[] {160,4,174,1},
						new Predicate("current_pair", new Term[] {
							new Variable(Type.STRING, "player1",false),
							new Variable(Type.STRING, "player2",false)
						}),
						new Block(
							"Main", new int[] {160,58,173,5},
							new Statement[] {
								new ForEach(
									"Main", new int[] {161,8,173,5},
									new Predicate("match_number", new Term[] {
										new Variable(Type.INTEGER, "num",false)
									}),
									new Block(
										"Main", new int[] {161,39,172,9},
										new Statement[] {
											new If(
												"Main", new int[] {162,12,172,9},
												new Comparison("==",
													new Variable(Type.INTEGER, "num"),
													Primitive.newPrimitive(1)
												),
												new Block(
													"Main", new int[] {162,24,165,13},
													new Statement[] {
														new BeliefUpdate('+',
															"Main", new int[] {163,16,165,13},
															new Predicate("player", new Term[] {
																Primitive.newPrimitive("ttt:XPlayerRole"),
																Operator.newOperator('+',
																	Primitive.newPrimitive("http://127.0.0.1:9000/"),
																	new Variable(Type.STRING, "player1")
																)
															})
														),
														new BeliefUpdate('+',
															"Main", new int[] {164,16,165,13},
															new Predicate("player", new Term[] {
																Primitive.newPrimitive("ttt:OPlayerRole"),
																Operator.newOperator('+',
																	Primitive.newPrimitive("http://127.0.0.1:9000/"),
																	new Variable(Type.STRING, "player2")
																)
															})
														)
													}
												),
												new If(
													"Main", new int[] {165,19,172,9},
													new Comparison("==",
														new Variable(Type.INTEGER, "num"),
														Primitive.newPrimitive(2)
													),
													new Block(
														"Main", new int[] {165,31,168,13},
														new Statement[] {
															new BeliefUpdate('+',
																"Main", new int[] {166,16,168,13},
																new Predicate("player", new Term[] {
																	Primitive.newPrimitive("ttt:XPlayerRole"),
																	Primitive.newPrimitive("http://127.0.0.1:9000/NewPlayer")
																})
															),
															new BeliefUpdate('+',
																"Main", new int[] {167,16,168,13},
																new Predicate("player", new Term[] {
																	Primitive.newPrimitive("ttt:OPlayerRole"),
																	Primitive.newPrimitive("http://127.0.0.1:9000/Better")
																})
															)
														}
													),
													new If(
														"Main", new int[] {168,19,172,9},
														new Comparison("==",
															new Variable(Type.INTEGER, "num"),
															Primitive.newPrimitive(3)
														),
														new Block(
															"Main", new int[] {168,31,171,13},
															new Statement[] {
																new BeliefUpdate('+',
																	"Main", new int[] {169,16,171,13},
																	new Predicate("player", new Term[] {
																		Primitive.newPrimitive("ttt:XPlayerRole"),
																		Operator.newOperator('+',
																			Primitive.newPrimitive("http://127.0.0.1:9000/"),
																			new Variable(Type.STRING, "player1")
																		)
																	})
																),
																new BeliefUpdate('+',
																	"Main", new int[] {170,16,171,13},
																	new Predicate("player", new Term[] {
																		Primitive.newPrimitive("ttt:OPlayerRole"),
																		Operator.newOperator('+',
																			Primitive.newPrimitive("http://127.0.0.1:9000/"),
																			new Variable(Type.STRING, "player2")
																		)
																	})
																)
															}
														)
													)
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
			"Main", new int[] {176,8,176,128},
			new BeliefEvent('+',
				new Predicate("form_actions", new Term[] {
					new Variable(Type.STRING, "form_url",false),
					new Variable(Type.STRING, "http_method",false),
					new Variable(Type.LIST, "required_actions",false)
				})
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "form_url"),
					Primitive.newPrimitive("registerGame")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {176,127,225,1},
				new Statement[] {
					new TryRecover(
						"Main", new int[] {177,4,225,1},
						new Block(
							"Main", new int[] {177,8,222,5},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {178,8,178,61},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("===Before JSONNODE BODYJSON!!!====")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Declaration(
									new Variable(new ObjectType(JsonNode.class), "bodyJson"),
									"Main", new int[] {179,8,222,5},
									new ModuleTerm("builder", new ObjectType(com.fasterxml.jackson.databind.JsonNode.class),
										new Predicate("createObject", new Term[] {}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Main","builder")).createObject(
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Main","builder")).createObject(
												);
											}
										}
									)
								),
								new Declaration(
									new Variable(Type.BOOLEAN, "hasXPlayer"),
									"Main", new int[] {181,8,222,5},
									Primitive.newPrimitive(false)
								),
								new Declaration(
									new Variable(Type.BOOLEAN, "hasOPlayer"),
									"Main", new int[] {182,8,222,5},
									Primitive.newPrimitive(false)
								),
								new ForEach(
									"Main", new int[] {184,8,222,5},
									new Predicate("player", new Term[] {
										new Variable(Type.STRING, "role",false),
										new Variable(Type.STRING, "url",false)
									}),
									new Block(
										"Main", new int[] {184,49,187,9},
										new Statement[] {
											new If(
												"Main", new int[] {185,12,187,9},
												new ModuleFormula("strings",
													new Predicate("equal", new Term[] {
														new Variable(Type.STRING, "role"),
														Primitive.newPrimitive("ttt:XPlayerRole")
													}),
												new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
																(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.String) visitor.evaluate(predicate.getTerm(1))
															);
													}
												}
													),
												new Assignment(
													new Variable(Type.BOOLEAN, "hasXPlayer"),
													"Main", new int[] {185,55,187,9},
													Primitive.newPrimitive(true)
												)
											),
											new If(
												"Main", new int[] {186,12,187,9},
												new ModuleFormula("strings",
													new Predicate("equal", new Term[] {
														new Variable(Type.STRING, "role"),
														Primitive.newPrimitive("ttt:OPlayerRole")
													}),
												new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
																(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																(java.lang.String) visitor.evaluate(predicate.getTerm(1))
															);
													}
												}
													),
												new Assignment(
													new Variable(Type.BOOLEAN, "hasOPlayer"),
													"Main", new int[] {186,55,187,9},
													Primitive.newPrimitive(true)
												)
											)
										}
									)
								),
								new If(
									"Main", new int[] {189,8,222,5},
									new OR(
										new NOT(
											new BooleanTermFormula(
												new Variable(Type.BOOLEAN, "hasXPlayer")
											)
										),
										new NOT(
											new BooleanTermFormula(
												new Variable(Type.BOOLEAN, "hasOPlayer")
											)
										)
									),
									new Block(
										"Main", new int[] {189,38,191,9},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {190,12,190,61},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Missing required player roles!")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new ForAll(
									"Main", new int[] {193,8,193,46},
									new Variable(Type.STRING, "item",false),
									new Variable(Type.LIST, "required_actions"),
									new Block(
										"Main", new int[] {193,47,222,5},
										new Statement[] {
											new If(
												"Main", new int[] {194,12,202,9},
												new AND(
													new ModuleFormula("strings",
														new Predicate("equal", new Term[] {
															new Variable(Type.STRING, "item"),
															Primitive.newPrimitive("ttt:OPlayerRole")
														}),
													new ModuleFormulaAdaptor() {
															public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
																	(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																	(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																);
														}
													}
														),
													new Predicate("player", new Term[] {
														Primitive.newPrimitive("ttt:OPlayerRole"),
														new Variable(Type.STRING, "playerURL",false)
													})
												),
												new Block(
													"Main", new int[] {194,102,197,13},
													new Statement[] {
														new ModuleCall("builder",
															"Main", new int[] {195,16,195,62},
															new Predicate("addProperty", new Term[] {
																new Variable(new ObjectType(JsonNode.class), "bodyJson"),
																new Variable(Type.STRING, "item"),
																new Variable(Type.STRING, "playerURL")
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((mams.JSONBuilder) intention.getModule("Main","builder")).addProperty(
																		(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(1)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(2))
																	);
																}
															}
														),
														new ModuleCall("console",
															"Main", new int[] {196,16,196,63},
															new Predicate("println", new Term[] {
																Operator.newOperator('+',
																	Primitive.newPrimitive("Added O player: "),
																	new Variable(Type.STRING, "playerURL")
																)
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Console) intention.getModule("Main","console")).println(
																		(java.lang.String) intention.evaluate(predicate.getTerm(0))
																	);
																}
															}
														)
													}
												)
											),
											new If(
												"Main", new int[] {198,12,202,9},
												new AND(
													new ModuleFormula("strings",
														new Predicate("equal", new Term[] {
															new Variable(Type.STRING, "item"),
															Primitive.newPrimitive("ttt:XPlayerRole")
														}),
													new ModuleFormulaAdaptor() {
															public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
																	(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																	(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																);
														}
													}
														),
													new Predicate("player", new Term[] {
														Primitive.newPrimitive("ttt:XPlayerRole"),
														new Variable(Type.STRING, "playerURL",false)
													})
												),
												new Block(
													"Main", new int[] {198,102,201,13},
													new Statement[] {
														new ModuleCall("builder",
															"Main", new int[] {199,16,199,62},
															new Predicate("addProperty", new Term[] {
																new Variable(new ObjectType(JsonNode.class), "bodyJson"),
																new Variable(Type.STRING, "item"),
																new Variable(Type.STRING, "playerURL")
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((mams.JSONBuilder) intention.getModule("Main","builder")).addProperty(
																		(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(1)),
																		(java.lang.String) intention.evaluate(predicate.getTerm(2))
																	);
																}
															}
														),
														new ModuleCall("console",
															"Main", new int[] {200,16,200,63},
															new Predicate("println", new Term[] {
																Operator.newOperator('+',
																	Primitive.newPrimitive("Added X player: "),
																	new Variable(Type.STRING, "playerURL")
																)
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Console) intention.getModule("Main","console")).println(
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
								),
								new Declaration(
									new Variable(Type.STRING, "bodyStr"),
									"Main", new int[] {204,8,222,5},
									new ModuleTerm("builder", Type.STRING,
										new Predicate("toJsonString", new Term[] {
											new Variable(new ObjectType(JsonNode.class), "bodyJson")
										}),
										new ModuleTermAdaptor() {
											public Object invoke(Intention intention, Predicate predicate) {
												return ((mams.JSONBuilder) intention.getModule("Main","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) intention.evaluate(predicate.getTerm(0))
												);
											}
											public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((mams.JSONBuilder) visitor.agent().getModule("Main","builder")).toJsonString(
													(com.fasterxml.jackson.databind.JsonNode) visitor.evaluate(predicate.getTerm(0))
												);
											}
										}
									)
								),
								new ModuleCall("console",
									"Main", new int[] {205,8,205,51},
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
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new If(
									"Main", new int[] {207,8,222,5},
									new ModuleFormula("strings",
										new Predicate("equal", new Term[] {
											new Variable(Type.STRING, "http_method"),
											Primitive.newPrimitive("POST")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Main", new int[] {207,48,213,9},
										new Statement[] {
											new ScopedSubgoal(
												"Main", new int[] {208,12,213,9},
												"MAMSAgent",
												new Goal(
													new Predicate("post", new Term[] {
														new Variable(Type.STRING, "form_url"),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new Declaration(
												new Variable(Type.STRING, "responseBody"),
												"Main", new int[] {209,12,213,9},
												new ModuleTerm("httpUtils", Type.STRING,
													new Predicate("bodyAsString", new Term[] {
														new Variable(new ObjectType(HttpResponse.class), "response")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
																(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
																(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
															);
														}
													}
												)
											),
											new ModuleCall("console",
												"Main", new int[] {210,12,210,69},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("RegisterGame Response: "),
														new Variable(Type.STRING, "responseBody")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("knowledgeStore",
												"Main", new int[] {211,12,211,73},
												new Predicate("getKnowledgeFromString", new Term[] {
													new Variable(Type.STRING, "responseBody"),
													new Variable(Type.STRING, "form_url")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledgeFromString(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new ModuleCall("console",
												"Main", new int[] {212,12,212,71},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending POST request to register game...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									),
									new Block(
										"Main", new int[] {213,15,222,5},
										new Statement[] {
											new ScopedSubgoal(
												"Main", new int[] {214,12,220,9},
												"MAMSAgent",
												new Goal(
													new Predicate("put", new Term[] {
														new Variable(Type.STRING, "form_url"),
														new Variable(Type.STRING, "bodyStr"),
														new Variable(new ObjectType(HttpResponse.class), "response",false)
													})
												)
											),
											new Declaration(
												new Variable(Type.STRING, "responseBody"),
												"Main", new int[] {215,12,220,9},
												new ModuleTerm("httpUtils", Type.STRING,
													new Predicate("bodyAsString", new Term[] {
														new Variable(new ObjectType(HttpResponse.class), "response")
													}),
													new ModuleTermAdaptor() {
														public Object invoke(Intention intention, Predicate predicate) {
															return ((mams.HttpUtils) intention.getModule("Main","httpUtils")).bodyAsString(
																(mams.web.HttpResponse) intention.evaluate(predicate.getTerm(0))
															);
														}
														public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((mams.HttpUtils) visitor.agent().getModule("Main","httpUtils")).bodyAsString(
																(mams.web.HttpResponse) visitor.evaluate(predicate.getTerm(0))
															);
														}
													}
												)
											),
											new ModuleCall("console",
												"Main", new int[] {216,12,216,69},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("RegisterGame Response: "),
														new Variable(Type.STRING, "responseBody")
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("console",
												"Main", new int[] {217,12,217,70},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Sending PUT request to register game...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											),
											new ModuleCall("knowledgeStore",
												"Main", new int[] {218,12,218,73},
												new Predicate("getKnowledgeFromString", new Term[] {
													new Variable(Type.STRING, "responseBody"),
													new Variable(Type.STRING, "form_url")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).getKnowledgeFromString(
															(java.lang.String) intention.evaluate(predicate.getTerm(0)),
															(java.lang.String) intention.evaluate(predicate.getTerm(1))
														);
													}
												}
											),
											new ModuleCall("console",
												"Main", new int[] {219,12,219,67},
												new Predicate("println", new Term[] {
													Primitive.newPrimitive("Processing register game response...")
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								)
							}
						),
						new Block(
							"Main", new int[] {222,14,225,1},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {223,8,223,51},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("Failed to register game!")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
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
			"Main", new int[] {227,8,227,82},
			new ModuleEvent("knowledgeStore",
				"$re",
				new Predicate("read", new Term[] {
					new Variable(Type.STRING, "url",false)
				}),
				new ModuleEventAdaptor() {
					public Event generate(astra.core.Agent agent, Predicate predicate) {
						return ((astra.jena.KnowledgeStore) agent.getModule("Main","knowledgeStore")).read(
							predicate.getTerm(0)
						);
					}
				}
			),
			new ModuleFormula("strings",
				new Predicate("endsWith", new Term[] {
					new Variable(Type.STRING, "url"),
					Primitive.newPrimitive("registerGame")
				}),
			new ModuleFormulaAdaptor() {
					public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
						return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).endsWith(
							(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
							(java.lang.String) visitor.evaluate(predicate.getTerm(1))
						);
				}
			}
				),
			new Block(
				"Main", new int[] {227,81,246,4},
				new Statement[] {
					new If(
						"Main", new int[] {228,7,246,4},
						new ModuleFormula("ttt",
							new Predicate("hasID", new Term[] {
								new Variable(Type.STRING, "url"),
								new Variable(Type.STRING, "gameID",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Main","ttt")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						),
						new Block(
							"Main", new int[] {228,42,245,8},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {229,11,229,50},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											Primitive.newPrimitive("Game ID is "),
											new Variable(Type.STRING, "gameID")
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new ForEach(
									"Main", new int[] {231,11,245,8},
									new Predicate("game_started", new Term[] {
										new Variable(Type.STRING, "oldGameID",false)
									}),
									new Block(
										"Main", new int[] {231,51,233,12},
										new Statement[] {
											new BeliefUpdate('-',
												"Main", new int[] {232,15,233,12},
												new Predicate("game_started", new Term[] {
													new Variable(Type.STRING, "oldGameID")
												})
											)
										}
									)
								),
								new BeliefUpdate('+',
									"Main", new int[] {234,11,245,8},
									new Predicate("game_started", new Term[] {
										new Variable(Type.STRING, "gameID")
									})
								),
								new If(
									"Main", new int[] {236,11,245,8},
									new Predicate("player", new Term[] {
										Primitive.newPrimitive("ttt:XPlayerRole"),
										new Variable(Type.STRING, "xPlayerURL",false)
									}),
									new Block(
										"Main", new int[] {236,61,244,12},
										new Statement[] {
											new If(
												"Main", new int[] {237,15,244,12},
												new Predicate("player", new Term[] {
													Primitive.newPrimitive("ttt:OPlayerRole"),
													new Variable(Type.STRING, "oPlayerURL",false)
												}),
												new Block(
													"Main", new int[] {237,65,243,16},
													new Statement[] {
														new Send("Main", new int[] {238,19,238,88},
															new Performative("inform"),
															new Variable(Type.STRING, "xPlayerURL"),
															new Predicate("game", new Term[] {
																new Variable(Type.STRING, "gameID"),
																Primitive.newPrimitive("ttt:XPlayerRole"),
																new Variable(Type.STRING, "oPlayerURL")
															})
														),
														new ModuleCall("console",
															"Main", new int[] {239,19,239,79},
															new Predicate("println", new Term[] {
																Operator.newOperator('+',
																	Primitive.newPrimitive("Sent game info to X player: "),
																	new Variable(Type.STRING, "xPlayerURL")
																)
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Console) intention.getModule("Main","console")).println(
																		(java.lang.String) intention.evaluate(predicate.getTerm(0))
																	);
																}
															}
														),
														new Send("Main", new int[] {241,19,241,88},
															new Performative("inform"),
															new Variable(Type.STRING, "oPlayerURL"),
															new Predicate("game", new Term[] {
																new Variable(Type.STRING, "gameID"),
																Primitive.newPrimitive("ttt:OPlayerRole"),
																new Variable(Type.STRING, "xPlayerURL")
															})
														),
														new ModuleCall("console",
															"Main", new int[] {242,19,242,79},
															new Predicate("println", new Term[] {
																Operator.newOperator('+',
																	Primitive.newPrimitive("Sent game info to O player: "),
																	new Variable(Type.STRING, "oPlayerURL")
																)
															}),
															new DefaultModuleCallAdaptor() {
																public boolean inline() {
																	return true;
																}

																public boolean invoke(Intention intention, Predicate predicate) {
																	return ((astra.lang.Console) intention.getModule("Main","console")).println(
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
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {248,8,248,102},
			new MessageEvent(
				new Performative("inform"),
				new Variable(Type.STRING, "sender",false),
				new Predicate("game_completed", new Term[] {
					new Variable(Type.STRING, "id",false),
					new Variable(Type.STRING, "player_uri",false),
					new Variable(Type.STRING, "result",false)
				})
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {248,101,319,1},
				new Statement[] {
					new ModuleCall("console",
						"Main", new int[] {249,4,249,98},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("Game "),
								Operator.newOperator('+',
									new Variable(Type.STRING, "id"),
									Operator.newOperator('+',
										Primitive.newPrimitive(" completed. Player URI: "),
										Operator.newOperator('+',
											new Variable(Type.STRING, "player_uri"),
											Operator.newOperator('+',
												Primitive.newPrimitive(" Result: "),
												new Variable(Type.STRING, "result")
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
								return ((astra.lang.Console) intention.getModule("Main","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Declaration(
						new Variable(Type.STRING, "playerName"),
						"Main", new int[] {251,4,319,1},
						Primitive.newPrimitive("")
					),
					new Declaration(
						new Variable(Type.STRING, "opponent_uri"),
						"Main", new int[] {252,4,319,1},
						Primitive.newPrimitive("")
					),
					new ForEach(
						"Main", new int[] {254,4,319,1},
						new Predicate("current_pair", new Term[] {
							new Variable(Type.STRING, "p1",false),
							new Variable(Type.STRING, "p2",false)
						}),
						new Block(
							"Main", new int[] {254,48,260,5},
							new Statement[] {
								new If(
									"Main", new int[] {255,8,260,5},
									new ModuleFormula("strings",
										new Predicate("contains", new Term[] {
											new Variable(Type.STRING, "player_uri"),
											new Variable(Type.STRING, "p1")
										}),
									new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
													(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
													(java.lang.String) visitor.evaluate(predicate.getTerm(1))
												);
										}
									}
										),
									new Block(
										"Main", new int[] {255,45,257,9},
										new Statement[] {
											new Assignment(
												new Variable(Type.STRING, "opponent_uri"),
												"Main", new int[] {256,12,257,9},
												new Variable(Type.STRING, "p2")
											)
										}
									),
									new If(
										"Main", new int[] {257,15,260,5},
										new ModuleFormula("strings",
											new Predicate("contains", new Term[] {
												new Variable(Type.STRING, "player_uri"),
												new Variable(Type.STRING, "p2")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"Main", new int[] {257,52,259,9},
											new Statement[] {
												new Assignment(
													new Variable(Type.STRING, "opponent_uri"),
													"Main", new int[] {258,12,259,9},
													new Variable(Type.STRING, "p1")
												)
											}
										)
									)
								)
							}
						)
					),
					new If(
						"Main", new int[] {262,4,319,1},
						new ModuleFormula("strings",
							new Predicate("contains", new Term[] {
								new Variable(Type.STRING, "player_uri"),
								Primitive.newPrimitive("Better")
							}),
						new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
										(java.lang.String) visitor.evaluate(predicate.getTerm(1))
									);
							}
						}
							),
						new Block(
							"Main", new int[] {262,47,264,5},
							new Statement[] {
								new Assignment(
									new Variable(Type.STRING, "playerName"),
									"Main", new int[] {263,8,264,5},
									Primitive.newPrimitive("Better")
								)
							}
						),
						new If(
							"Main", new int[] {264,11,319,1},
							new ModuleFormula("strings",
								new Predicate("contains", new Term[] {
									new Variable(Type.STRING, "player_uri"),
									Primitive.newPrimitive("Opponent")
								}),
							new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
											(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
											(java.lang.String) visitor.evaluate(predicate.getTerm(1))
										);
								}
							}
								),
							new Block(
								"Main", new int[] {264,56,266,5},
								new Statement[] {
									new Assignment(
										new Variable(Type.STRING, "playerName"),
										"Main", new int[] {265,8,266,5},
										Primitive.newPrimitive("Opponent")
									)
								}
							),
							new If(
								"Main", new int[] {266,11,319,1},
								new ModuleFormula("strings",
									new Predicate("contains", new Term[] {
										new Variable(Type.STRING, "player_uri"),
										Primitive.newPrimitive("NewPlayer")
									}),
								new ModuleFormulaAdaptor() {
										public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(1))
											);
									}
								}
									),
								new Block(
									"Main", new int[] {266,57,268,5},
									new Statement[] {
										new Assignment(
											new Variable(Type.STRING, "playerName"),
											"Main", new int[] {267,8,268,5},
											Primitive.newPrimitive("NewPlayer")
										)
									}
								)
							)
						)
					),
					new If(
						"Main", new int[] {270,4,319,1},
						new ModuleFormula("strings",
							new Predicate("equal", new Term[] {
								new Variable(Type.STRING, "result"),
								Primitive.newPrimitive("win")
							}),
						new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
										(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
										(java.lang.String) visitor.evaluate(predicate.getTerm(1))
									);
							}
						}
							),
						new Block(
							"Main", new int[] {270,37,276,5},
							new Statement[] {
								new ForEach(
									"Main", new int[] {271,8,276,5},
									new Predicate("tournament_score", new Term[] {
										new Variable(Type.STRING, "playerName"),
										new Variable(Type.INTEGER, "score",false)
									}),
									new Block(
										"Main", new int[] {271,57,275,9},
										new Statement[] {
											new BeliefUpdate('-',
												"Main", new int[] {272,12,275,9},
												new Predicate("tournament_score", new Term[] {
													new Variable(Type.STRING, "playerName"),
													new Variable(Type.INTEGER, "score")
												})
											),
											new BeliefUpdate('+',
												"Main", new int[] {273,12,275,9},
												new Predicate("tournament_score", new Term[] {
													new Variable(Type.STRING, "playerName"),
													Operator.newOperator('+',
														new Variable(Type.INTEGER, "score"),
														Primitive.newPrimitive(1)
													)
												})
											),
											new ModuleCall("console",
												"Main", new int[] {274,12,274,82},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Updated score for "),
														Operator.newOperator('+',
															new Variable(Type.STRING, "playerName"),
															Operator.newOperator('+',
																Primitive.newPrimitive(": "),
																new Brackets(
																	Operator.newOperator('+',
																		new Variable(Type.INTEGER, "score"),
																		Primitive.newPrimitive(1)
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
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								)
							}
						),
						new If(
							"Main", new int[] {276,11,319,1},
							new ModuleFormula("strings",
								new Predicate("equal", new Term[] {
									new Variable(Type.STRING, "result"),
									Primitive.newPrimitive("lose")
								}),
							new ModuleFormulaAdaptor() {
									public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).equal(
											(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
											(java.lang.String) visitor.evaluate(predicate.getTerm(1))
										);
								}
							}
								),
							new Block(
								"Main", new int[] {276,45,294,5},
								new Statement[] {
									new Declaration(
										new Variable(Type.STRING, "winner"),
										"Main", new int[] {277,8,294,5},
										Primitive.newPrimitive("")
									),
									new If(
										"Main", new int[] {278,8,294,5},
										new ModuleFormula("strings",
											new Predicate("contains", new Term[] {
												new Variable(Type.STRING, "player_uri"),
												Primitive.newPrimitive("Better")
											}),
										new ModuleFormulaAdaptor() {
												public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
														(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
														(java.lang.String) visitor.evaluate(predicate.getTerm(1))
													);
											}
										}
											),
										new Block(
											"Main", new int[] {278,51,281,9},
											new Statement[] {
												new If(
													"Main", new int[] {279,12,281,9},
													new ModuleFormula("strings",
														new Predicate("contains", new Term[] {
															new Variable(Type.STRING, "opponent_uri"),
															Primitive.newPrimitive("Opponent")
														}),
													new ModuleFormulaAdaptor() {
															public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
																	(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																	(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																);
														}
													}
														),
													new Assignment(
														new Variable(Type.STRING, "winner"),
														"Main", new int[] {279,59,281,9},
														Primitive.newPrimitive("Opponent")
													),
													new Assignment(
														new Variable(Type.STRING, "winner"),
														"Main", new int[] {280,17,281,9},
														Primitive.newPrimitive("NewPlayer")
													)
												)
											}
										),
										new If(
											"Main", new int[] {281,15,294,5},
											new ModuleFormula("strings",
												new Predicate("contains", new Term[] {
													new Variable(Type.STRING, "player_uri"),
													Primitive.newPrimitive("Opponent")
												}),
											new ModuleFormulaAdaptor() {
													public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
														return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
															(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
															(java.lang.String) visitor.evaluate(predicate.getTerm(1))
														);
												}
											}
												),
											new Block(
												"Main", new int[] {281,60,284,9},
												new Statement[] {
													new If(
														"Main", new int[] {282,12,284,9},
														new ModuleFormula("strings",
															new Predicate("contains", new Term[] {
																new Variable(Type.STRING, "opponent_uri"),
																Primitive.newPrimitive("Better")
															}),
														new ModuleFormulaAdaptor() {
																public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
																		(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																		(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																	);
															}
														}
															),
														new Assignment(
															new Variable(Type.STRING, "winner"),
															"Main", new int[] {282,57,284,9},
															Primitive.newPrimitive("Better")
														),
														new Assignment(
															new Variable(Type.STRING, "winner"),
															"Main", new int[] {283,17,284,9},
															Primitive.newPrimitive("NewPlayer")
														)
													)
												}
											),
											new Block(
												"Main", new int[] {284,15,294,5},
												new Statement[] {
													new If(
														"Main", new int[] {285,12,287,9},
														new ModuleFormula("strings",
															new Predicate("contains", new Term[] {
																new Variable(Type.STRING, "opponent_uri"),
																Primitive.newPrimitive("Better")
															}),
														new ModuleFormulaAdaptor() {
																public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
																	return ((astra.lang.Strings) visitor.agent().getModule("Main","strings")).contains(
																		(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
																		(java.lang.String) visitor.evaluate(predicate.getTerm(1))
																	);
															}
														}
															),
														new Assignment(
															new Variable(Type.STRING, "winner"),
															"Main", new int[] {285,57,287,9},
															Primitive.newPrimitive("Better")
														),
														new Assignment(
															new Variable(Type.STRING, "winner"),
															"Main", new int[] {286,17,287,9},
															Primitive.newPrimitive("Opponent")
														)
													)
												}
											)
										)
									),
									new ForEach(
										"Main", new int[] {289,8,294,5},
										new Predicate("tournament_score", new Term[] {
											new Variable(Type.STRING, "winner"),
											new Variable(Type.INTEGER, "score",false)
										}),
										new Block(
											"Main", new int[] {289,53,293,9},
											new Statement[] {
												new BeliefUpdate('-',
													"Main", new int[] {290,12,293,9},
													new Predicate("tournament_score", new Term[] {
														new Variable(Type.STRING, "winner"),
														new Variable(Type.INTEGER, "score")
													})
												),
												new BeliefUpdate('+',
													"Main", new int[] {291,12,293,9},
													new Predicate("tournament_score", new Term[] {
														new Variable(Type.STRING, "winner"),
														Operator.newOperator('+',
															new Variable(Type.INTEGER, "score"),
															Primitive.newPrimitive(1)
														)
													})
												),
												new ModuleCall("console",
													"Main", new int[] {292,12,292,85},
													new Predicate("println", new Term[] {
														Operator.newOperator('+',
															Primitive.newPrimitive("Updated score for winner "),
															Operator.newOperator('+',
																new Variable(Type.STRING, "winner"),
																Operator.newOperator('+',
																	Primitive.newPrimitive(": "),
																	new Brackets(
																		Operator.newOperator('+',
																			new Variable(Type.INTEGER, "score"),
																			Primitive.newPrimitive(1)
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
															return ((astra.lang.Console) intention.getModule("Main","console")).println(
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
					),
					new Declaration(
						new Variable(Type.INTEGER, "match"),
						"Main", new int[] {296,4,319,1},
						Primitive.newPrimitive(0)
					),
					new ForEach(
						"Main", new int[] {297,4,319,1},
						new Predicate("match_number", new Term[] {
							new Variable(Type.INTEGER, "n",false)
						}),
						new Block(
							"Main", new int[] {297,33,299,5},
							new Statement[] {
								new Assignment(
									new Variable(Type.INTEGER, "match"),
									"Main", new int[] {298,8,299,5},
									new Variable(Type.INTEGER, "n")
								)
							}
						)
					),
					new If(
						"Main", new int[] {301,4,319,1},
						new Comparison("==",
							new Variable(Type.INTEGER, "match"),
							Primitive.newPrimitive(3)
						),
						new Block(
							"Main", new int[] {301,18,313,5},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {302,8,302,55},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("\n=== Tournament Results ===")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new ForEach(
									"Main", new int[] {303,8,313,5},
									new Predicate("tournament_score", new Term[] {
										Primitive.newPrimitive("Better"),
										new Variable(Type.INTEGER, "score1",false)
									}),
									new Block(
										"Main", new int[] {303,56,305,9},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {304,12,304,58},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Better: "),
														Operator.newOperator('+',
															new Variable(Type.INTEGER, "score1"),
															Primitive.newPrimitive(" wins")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new ForEach(
									"Main", new int[] {306,8,313,5},
									new Predicate("tournament_score", new Term[] {
										Primitive.newPrimitive("Opponent"),
										new Variable(Type.INTEGER, "score2",false)
									}),
									new Block(
										"Main", new int[] {306,58,308,9},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {307,12,307,60},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("Opponent: "),
														Operator.newOperator('+',
															new Variable(Type.INTEGER, "score2"),
															Primitive.newPrimitive(" wins")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new ForEach(
									"Main", new int[] {309,8,313,5},
									new Predicate("tournament_score", new Term[] {
										Primitive.newPrimitive("NewPlayer"),
										new Variable(Type.INTEGER, "score3",false)
									}),
									new Block(
										"Main", new int[] {309,59,311,9},
										new Statement[] {
											new ModuleCall("console",
												"Main", new int[] {310,12,310,61},
												new Predicate("println", new Term[] {
													Operator.newOperator('+',
														Primitive.newPrimitive("NewPlayer: "),
														Operator.newOperator('+',
															new Variable(Type.INTEGER, "score3"),
															Primitive.newPrimitive(" wins")
														)
													)
												}),
												new DefaultModuleCallAdaptor() {
													public boolean inline() {
														return true;
													}

													public boolean invoke(Intention intention, Predicate predicate) {
														return ((astra.lang.Console) intention.getModule("Main","console")).println(
															(java.lang.String) intention.evaluate(predicate.getTerm(0))
														);
													}
												}
											)
										}
									)
								),
								new ModuleCall("console",
									"Main", new int[] {312,8,312,53},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("========================\n")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						),
						new Block(
							"Main", new int[] {313,11,319,1},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {314,8,314,54},
									new Predicate("println", new Term[] {
										Primitive.newPrimitive("=== Tournament Starting ===")
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new BeliefUpdate('-',
									"Main", new int[] {315,8,318,5},
									new Predicate("match_number", new Term[] {
										new Variable(Type.INTEGER, "match")
									})
								),
								new BeliefUpdate('+',
									"Main", new int[] {316,8,318,5},
									new Predicate("match_number", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.INTEGER, "match"),
											Primitive.newPrimitive(1)
										)
									})
								),
								new Subgoal(
									"Main", new int[] {317,8,318,5},
									new Goal(
										new Predicate("start_next_match", new Term[] {})
									)
								)
							}
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {321,9,321,31},
			new GoalEvent('+',
				new Goal(
					new Predicate("start_next_match", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {321,30,332,1},
				new Statement[] {
					new ForEach(
						"Main", new int[] {322,4,332,1},
						new Predicate("match_number", new Term[] {
							new Variable(Type.INTEGER, "num",false)
						}),
						new Block(
							"Main", new int[] {322,35,330,5},
							new Statement[] {
								new If(
									"Main", new int[] {323,8,330,5},
									new Comparison("==",
										new Variable(Type.INTEGER, "num"),
										Primitive.newPrimitive(2)
									),
									new Block(
										"Main", new int[] {323,20,326,9},
										new Statement[] {
											new BeliefUpdate('-',
												"Main", new int[] {324,12,326,9},
												new Predicate("current_pair", new Term[] {
													Primitive.newPrimitive("Better"),
													Primitive.newPrimitive("Opponent")
												})
											),
											new BeliefUpdate('+',
												"Main", new int[] {325,12,326,9},
												new Predicate("current_pair", new Term[] {
													Primitive.newPrimitive("Better"),
													Primitive.newPrimitive("NewPlayer")
												})
											)
										}
									),
									new If(
										"Main", new int[] {326,15,330,5},
										new Comparison("==",
											new Variable(Type.INTEGER, "num"),
											Primitive.newPrimitive(3)
										),
										new Block(
											"Main", new int[] {326,27,329,9},
											new Statement[] {
												new BeliefUpdate('-',
													"Main", new int[] {327,12,329,9},
													new Predicate("current_pair", new Term[] {
														Primitive.newPrimitive("Better"),
														Primitive.newPrimitive("NewPlayer")
													})
												),
												new BeliefUpdate('+',
													"Main", new int[] {328,12,329,9},
													new Predicate("current_pair", new Term[] {
														Primitive.newPrimitive("Opponent"),
														Primitive.newPrimitive("NewPlayer")
													})
												)
											}
										)
									)
								)
							}
						)
					),
					new Subgoal(
						"Main", new int[] {331,4,332,1},
						new Goal(
							new Predicate("setup_current_match", new Term[] {})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {333,5,333,35},
			new GoalEvent('+',
				new Goal(
					new Predicate("print_tournament_results", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {333,34,340,4},
				new Statement[] {
					new ModuleCall("console",
						"Main", new int[] {334,7,334,54},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("\n=== Tournament Results ===")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ForEach(
						"Main", new int[] {335,7,340,4},
						new Predicate("tournament_score", new Term[] {
							new Variable(Type.STRING, "playerName",false),
							new Variable(Type.INTEGER, "score",false)
						}),
						new Block(
							"Main", new int[] {335,63,337,8},
							new Statement[] {
								new ModuleCall("console",
									"Main", new int[] {336,11,336,63},
									new Predicate("println", new Term[] {
										Operator.newOperator('+',
											new Variable(Type.STRING, "playerName"),
											Operator.newOperator('+',
												Primitive.newPrimitive(": "),
												Operator.newOperator('+',
													new Variable(Type.INTEGER, "score"),
													Primitive.newPrimitive(" wins")
												)
											)
										)
									}),
									new DefaultModuleCallAdaptor() {
										public boolean inline() {
											return true;
										}

										public boolean invoke(Intention intention, Predicate predicate) {
											return ((astra.lang.Console) intention.getModule("Main","console")).println(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
									}
								)
							}
						)
					),
					new ModuleCall("console",
						"Main", new int[] {338,7,338,52},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("========================\n")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("Main","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"Main", new int[] {339,7,339,20},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("Main","system")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"Main", new int[] {342,8,342,29},
			new GoalEvent('+',
				new Goal(
					new Predicate("clear_knowledge", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"Main", new int[] {342,28,353,4},
				new Statement[] {
					new ModuleCall("knowledgeStore",
						"Main", new int[] {343,7,343,29},
						new Predicate("clear", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.jena.KnowledgeStore) intention.getModule("Main","knowledgeStore")).clear(
								);
							}
						}
					),
					new ForEach(
						"Main", new int[] {344,7,353,4},
						new Predicate("form_actions", new Term[] {
							new Variable(Type.STRING, "anyForm",false),
							new Variable(Type.STRING, "method_name",false),
							new Variable(Type.LIST, "any_list",false)
						}),
						new Block(
							"Main", new int[] {344,80,346,8},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {345,11,346,8},
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
						"Main", new int[] {347,7,353,4},
						new Predicate("link_actions", new Term[] {
							new Variable(Type.STRING, "anyLink",false)
						}),
						new Block(
							"Main", new int[] {347,45,349,8},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {348,11,349,8},
									new Predicate("link_actions", new Term[] {
										new Variable(Type.STRING, "anyLink")
									})
								)
							}
						)
					),
					new ForEach(
						"Main", new int[] {350,7,353,4},
						new Predicate("game_started", new Term[] {
							new Variable(Type.STRING, "id",false)
						}),
						new Block(
							"Main", new int[] {350,41,352,8},
							new Statement[] {
								new BeliefUpdate('-',
									"Main", new int[] {351,11,352,8},
									new Predicate("game_started", new Term[] {
										new Variable(Type.STRING, "id")
									})
								)
							}
						)
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Predicate("api_index_url", new Term[] {
				Primitive.newPrimitive("http://localhost:8083/")
			})
		);
		agent.initialize(
			new Predicate("match_number", new Term[] {
				Primitive.newPrimitive(1)
			})
		);
		agent.initialize(
			new Predicate("match_complete", new Term[] {
				Primitive.newPrimitive(false)
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
		agent.initialize(
			new Predicate("tournament_score", new Term[] {
				Primitive.newPrimitive("Better"),
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("tournament_score", new Term[] {
				Primitive.newPrimitive("Opponent"),
				Primitive.newPrimitive(0)
			})
		);
		agent.initialize(
			new Predicate("tournament_score", new Term[] {
				Primitive.newPrimitive("NewPlayer"),
				Primitive.newPrimitive(0)
			})
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("knowledgeStore",astra.jena.KnowledgeStore.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
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
			astra.core.Agent agent = new Main().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Main");
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

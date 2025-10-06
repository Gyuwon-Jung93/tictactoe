package mams;
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

import mams.web.HttpRequest.HttpRequestBuilder;
import mams.web.HttpResponse;
import mams.web.HttpRequest;

public class MAMSAgent extends ASTRAClass {
	public MAMSAgent() {
		setParents(new Class[] {astra.lang.Agent.class});
		addInference(new Inference(
			new Predicate("have", new Term[] {
				new Variable(Type.STRING, "name",false)
			}),
			new Predicate("artifact", new Term[] {
				new Variable(Type.STRING, "name"),
				new Variable(Type.STRING, "qualifiedName",false),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			})
		));
		addInference(new Inference(
			new Predicate("created", new Term[] {
				new Variable(Type.STRING, "qualifiedName",false)
			}),
			new Predicate("artifact", new Term[] {
				new Variable(Type.STRING, "name",false),
				new Variable(Type.STRING, "qualifiedName"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			})
		));
		addInference(new Inference(
			new Predicate("uri", new Term[] {
				new Variable(Type.STRING, "name",false),
				new Variable(Type.STRING, "uri",false)
			}),
			new AND(
				new Predicate("artifact", new Term[] {
					new Variable(Type.STRING, "name"),
					new Variable(Type.STRING, "artifact_name",false),
					new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
				}),
				new Predicate("uri", new Term[] {
					new Variable(Type.STRING, "artifact_name"),
					new Variable(Type.STRING, "uri")
				})
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {39,9,39,19},
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"mams.MAMSAgent", new int[] {39,18,43,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {40,8,40,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).link(
								);
							}
						}
					),
					new Subgoal(
						"mams.MAMSAgent", new int[] {41,8,43,5},
						new Goal(
							new Predicate("have", new Term[] {
								Primitive.newPrimitive("webserver")
							})
						)
					),
					new Subgoal(
						"mams.MAMSAgent", new int[] {42,8,43,5},
						new Goal(
							new Predicate("have", new Term[] {
								Primitive.newPrimitive("restclient")
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {45,9,45,44},
			new GoalEvent('+',
				new Goal(
					new Predicate("have", new Term[] {
						new Variable(Type.STRING, "name",false)
					})
				)
			),
			new NOT(
				new Predicate("have", new Term[] {
					new Variable(Type.STRING, "name")
				})
			),
			new Block(
				"mams.MAMSAgent", new int[] {45,43,48,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {46,8,46,59},
						new Predicate("lookupArtifact", new Term[] {
							new Variable(Type.STRING, "name"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {47,8,48,5},
						new Predicate("artifact", new Term[] {
							new Variable(Type.STRING, "name"),
							new Variable(Type.STRING, "name"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {54,9,54,20},
			new GoalEvent('+',
				new Goal(
					new Predicate("setup", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"mams.MAMSAgent", new int[] {54,19,56,5},
				new Statement[] {
					new Subgoal(
						"mams.MAMSAgent", new int[] {55,8,56,5},
						new Goal(
							new Predicate("setup", new Term[] {
								Primitive.newPrimitive(9000)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {58,9,58,35},
			new GoalEvent('+',
				new Goal(
					new Predicate("setup", new Term[] {
						new Variable(Type.INTEGER, "port_number",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"mams.MAMSAgent", new int[] {58,34,70,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {59,8,59,30},
						new Predicate("startService", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).startService(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {60,8,60,22},
						new Predicate("link", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).link(
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {62,8,62,131},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("webserver"),
							Primitive.newPrimitive("mams.artifacts.WebServerArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {
										new Variable(Type.INTEGER, "port_number")
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {63,8,70,5},
						new Predicate("artifact", new Term[] {
							Primitive.newPrimitive("webserver"),
							Primitive.newPrimitive("webserver"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {65,8,65,117},
						new Predicate("makeArtifact", new Term[] {
							Primitive.newPrimitive("restclient"),
							Primitive.newPrimitive("mams.artifacts.RESTArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {

									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id2",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {66,8,70,5},
						new Predicate("artifact", new Term[] {
							Primitive.newPrimitive("restclient"),
							Primitive.newPrimitive("restclient"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id2")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {76,9,77,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("get", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {77,74,79,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {78,8,78,68},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("get", new Term[] {
										new Variable(Type.STRING, "uri")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).get(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).get(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {81,9,82,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("get", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.LIST, "headers",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {82,74,84,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {83,8,83,77},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("get", new Term[] {
										new Variable(Type.STRING, "uri"),
										new Variable(Type.LIST, "headers")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).get(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).get(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(1))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {86,9,87,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("options", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {87,74,89,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {88,8,88,72},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("options", new Term[] {
										new Variable(Type.STRING, "uri")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).options(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).options(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {91,9,92,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("head", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {92,74,94,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {93,8,93,69},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("head", new Term[] {
										new Variable(Type.STRING, "uri")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).head(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).head(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {97,9,98,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("post", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {98,74,102,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {99,8,101,9},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("post", new Term[] {
										new Variable(Type.STRING, "uri"),
										new ListTerm(new Term[] {
											new Funct("header", new Term[] {
												Primitive.newPrimitive("Content-Type"),
												Primitive.newPrimitive("application/json")
											})
										}),
										new Variable(Type.STRING, "jsonBody")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).post(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).post(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(1)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {104,9,105,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("patch", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {105,74,109,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {106,8,108,9},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("patch", new Term[] {
										new Variable(Type.STRING, "uri"),
										new ListTerm(new Term[] {
											new Funct("header", new Term[] {
												Primitive.newPrimitive("Content-Type"),
												Primitive.newPrimitive("application/json")
											})
										}),
										new Variable(Type.STRING, "jsonBody")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).patch(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).patch(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(1)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {111,9,112,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("put", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {112,74,116,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {113,8,115,9},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("put", new Term[] {
										new Variable(Type.STRING, "uri"),
										new ListTerm(new Term[] {
											new Funct("header", new Term[] {
												Primitive.newPrimitive("Content-Type"),
												Primitive.newPrimitive("application/json")
											})
										}),
										new Variable(Type.STRING, "jsonBody")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).put(
												(java.lang.String) intention.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) intention.evaluate(predicate.getTerm(1)),
												(java.lang.String) intention.evaluate(predicate.getTerm(2))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).put(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0)),
												(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(1)),
												(java.lang.String) visitor.evaluate(predicate.getTerm(2))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {118,9,119,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("delete", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(new ObjectType(HttpResponse.class), "response",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {119,74,121,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {120,8,120,71},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new ModuleTerm("httpUtils", new ObjectType(mams.web.HttpRequest.class),
									new Predicate("delete", new Term[] {
										new Variable(Type.STRING, "uri")
									}),
									new ModuleTermAdaptor() {
										public Object invoke(Intention intention, Predicate predicate) {
											return ((mams.HttpUtils) intention.getModule("mams.MAMSAgent","httpUtils")).delete(
												(java.lang.String) intention.evaluate(predicate.getTerm(0))
											);
										}
										public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
											return ((mams.HttpUtils) visitor.agent().getModule("mams.MAMSAgent","httpUtils")).delete(
												(java.lang.String) visitor.evaluate(predicate.getTerm(0))
											);
										}
									}
								),
								new Variable(new ObjectType(HttpResponse.class), "response")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {124,9,125,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("httpRequest", new Term[] {
						new Variable(new ObjectType(HttpRequest.class), "httpRequest",false),
						new Variable(new ObjectType(HttpResponse.class), "repsonse",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {125,74,127,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {126,8,126,61},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("execute", new Term[] {
								new Variable(new ObjectType(HttpRequest.class), "httpRequest"),
								new Variable(new ObjectType(HttpResponse.class), "repsonse")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {133,9,134,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("post", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {134,74,136,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {135,8,135,100},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("postRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								new Variable(Type.STRING, "jsonBody"),
								Primitive.newPrimitive("application/json"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {138,9,139,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("post", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(Type.STRING, "mediaType",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {139,74,141,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {140,8,140,91},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("postRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								new Variable(Type.STRING, "jsonBody"),
								new Variable(Type.STRING, "mediaType"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {143,9,144,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("put", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {144,74,146,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {145,8,145,99},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("putRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								new Variable(Type.STRING, "jsonBody"),
								Primitive.newPrimitive("application/json"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {148,9,149,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("put", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "jsonBody",false),
						new Variable(Type.STRING, "mediaType",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {149,74,151,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {150,8,150,90},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("putRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								new Variable(Type.STRING, "jsonBody"),
								new Variable(Type.STRING, "mediaType"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {153,9,154,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("get", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {154,74,156,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {155,8,155,89},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("getRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								Primitive.newPrimitive("application/json"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {158,9,159,75},
			new GoalEvent('+',
				new Goal(
					new Predicate("get", new Term[] {
						new Variable(Type.STRING, "uri",false),
						new Variable(Type.STRING, "mediaType",false),
						new Variable(Type.INTEGER, "responseCode",false),
						new Variable(Type.STRING, "content",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				Primitive.newPrimitive("restclient"),
				Primitive.newPrimitive("restclient"),
				new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {159,74,161,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {160,8,160,80},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("getRequest", new Term[] {
								new Variable(Type.STRING, "uri"),
								new Variable(Type.STRING, "mediaType"),
								new Variable(Type.INTEGER, "responseCode"),
								new Variable(Type.STRING, "content")
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {166,9,166,144},
			new GoalEvent('+',
				new Goal(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("base")
					})
				)
			),
			new AND(
				new NOT(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("base")
					})
				),
				new AND(
					new Predicate("baseArtifact", new Term[] {
						new Variable(Type.STRING, "cls",false)
					}),
					new Predicate("artifact", new Term[] {
						Primitive.newPrimitive("webserver"),
						new Variable(Type.STRING, "qualifiedName",false),
						new Variable(new ObjectType(cartago.ArtifactId.class), "id2",false)
					})
				)
			),
			new Block(
				"mams.MAMSAgent", new int[] {166,143,175,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "baseName"),
						"mams.MAMSAgent", new int[] {167,8,175,5},
						Operator.newOperator('+',
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("mams.MAMSAgent","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("mams.MAMSAgent","S")).name(
										);
									}
								}
							),
							Primitive.newPrimitive("-base")
						)
					),
					new ModuleCall("console",
						"mams.MAMSAgent", new int[] {168,8,168,48},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("creating: "),
								new Variable(Type.STRING, "baseName")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mams.MAMSAgent","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {169,8,169,94},
						new Predicate("makeArtifact", new Term[] {
							new Variable(Type.STRING, "baseName"),
							new Variable(Type.STRING, "cls"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {
										new ModuleTerm("S", Type.STRING,
											new Predicate("name", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.System) intention.getModule("mams.MAMSAgent","S")).name(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.System) visitor.agent().getModule("mams.MAMSAgent","S")).name(
													);
												}
											}
										)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {170,8,170,47},
						new Predicate("linkArtifacts", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							Primitive.newPrimitive("out-1"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id2")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {171,8,171,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {172,8,172,44},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("createRoute", new Term[] {})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {173,8,175,5},
						new Predicate("artifact", new Term[] {
							Primitive.newPrimitive("base"),
							new Variable(Type.STRING, "baseName"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {174,8,175,5},
						new Predicate("created", new Term[] {
							Primitive.newPrimitive("base")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {177,9,177,117},
			new GoalEvent('+',
				new Goal(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("base")
					})
				)
			),
			new AND(
				new NOT(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("base")
					})
				),
				new Predicate("artifact", new Term[] {
					Primitive.newPrimitive("webserver"),
					new Variable(Type.STRING, "qualifiedName",false),
					new Variable(new ObjectType(cartago.ArtifactId.class), "id2",false)
				})
			),
			new Block(
				"mams.MAMSAgent", new int[] {177,116,186,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "baseName"),
						"mams.MAMSAgent", new int[] {178,8,186,5},
						Operator.newOperator('+',
							new ModuleTerm("S", Type.STRING,
								new Predicate("name", new Term[] {}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.System) intention.getModule("mams.MAMSAgent","S")).name(
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.System) visitor.agent().getModule("mams.MAMSAgent","S")).name(
										);
									}
								}
							),
							Primitive.newPrimitive("-base")
						)
					),
					new ModuleCall("console",
						"mams.MAMSAgent", new int[] {179,8,179,48},
						new Predicate("println", new Term[] {
							Operator.newOperator('+',
								Primitive.newPrimitive("creating: "),
								new Variable(Type.STRING, "baseName")
							)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mams.MAMSAgent","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {180,8,180,120},
						new Predicate("makeArtifact", new Term[] {
							new Variable(Type.STRING, "baseName"),
							Primitive.newPrimitive("mams.artifacts.BaseArtifact"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {
										new ModuleTerm("S", Type.STRING,
											new Predicate("name", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((astra.lang.System) intention.getModule("mams.MAMSAgent","S")).name(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((astra.lang.System) visitor.agent().getModule("mams.MAMSAgent","S")).name(
													);
												}
											}
										)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mams.MAMSAgent","cartago")).params(
											(astra.term.ListTerm) visitor.evaluate(predicate.getTerm(0))
										);
									}
								}
							),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id",false)
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {181,8,181,47},
						new Predicate("linkArtifacts", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							Primitive.newPrimitive("out-1"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id2")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {182,8,182,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {183,8,183,44},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("createRoute", new Term[] {})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {184,8,186,5},
						new Predicate("artifact", new Term[] {
							Primitive.newPrimitive("base"),
							new Variable(Type.STRING, "baseName"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {185,8,186,5},
						new Predicate("created", new Term[] {
							Primitive.newPrimitive("base")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {188,9,188,99},
			new GoalEvent('+',
				new Goal(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("base")
					})
				)
			),
			new NOT(
				new Predicate("artifact", new Term[] {
					Primitive.newPrimitive("webserver"),
					new Variable(Type.STRING, "qualifiedName",false),
					new Variable(new ObjectType(cartago.ArtifactId.class), "id2",false)
				})
			),
			new Block(
				"mams.MAMSAgent", new int[] {188,98,191,5},
				new Statement[] {
					new ModuleCall("console",
						"mams.MAMSAgent", new int[] {189,8,189,76},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Attempt to create base, but agent Not Initialized")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("mams.MAMSAgent","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("S",
						"mams.MAMSAgent", new int[] {190,8,190,16},
						new Predicate("exit", new Term[] {}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return true;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("mams.MAMSAgent","S")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {196,9,196,57},
			new GoalEvent('+',
				new Goal(
					new Predicate("agentUri", new Term[] {
						new Variable(Type.STRING, "uri",false)
					})
				)
			),
			new Predicate("agentUri", new Term[] {
				new Variable(Type.STRING, "auri",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {196,56,196,69},
				new Statement[] {
					new Assignment(
						new Variable(Type.STRING, "uri"),
						"mams.MAMSAgent", new int[] {196,57,196,69},
						new Variable(Type.STRING, "auri")
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {197,9,197,51},
			new GoalEvent('+',
				new Goal(
					new Predicate("agentUri", new Term[] {
						new Variable(Type.STRING, "uri",false)
					})
				)
			),
			new Predicate("created", new Term[] {
				Primitive.newPrimitive("base")
			}),
			new Block(
				"mams.MAMSAgent", new int[] {197,50,201,5},
				new Statement[] {
					new Subgoal(
						"mams.MAMSAgent", new int[] {198,8,201,5},
						new Goal(
							new Predicate("itemProperty", new Term[] {
								Primitive.newPrimitive("base"),
								Primitive.newPrimitive("uri"),
								new Variable(Type.FUNCTION, "agentUri",false)
							})
						)
					),
					new Assignment(
						new Variable(Type.STRING, "uri"),
						"mams.MAMSAgent", new int[] {199,8,201,5},
						new ModuleTerm("F", Type.STRING,
							new Predicate("valueAsString", new Term[] {
								new Variable(Type.FUNCTION, "agentUri"),
								Primitive.newPrimitive(0)
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Functions) intention.getModule("mams.MAMSAgent","F")).valueAsString(
										(astra.term.Funct) intention.evaluate(predicate.getTerm(0)),
										(int) intention.evaluate(predicate.getTerm(1))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Functions) visitor.agent().getModule("mams.MAMSAgent","F")).valueAsString(
										(astra.term.Funct) visitor.evaluate(predicate.getTerm(0)),
										(int) visitor.evaluate(predicate.getTerm(1))
									);
								}
							}
						)
					),
					new BeliefUpdate('+',
						"mams.MAMSAgent", new int[] {200,8,201,5},
						new Predicate("agentUri", new Term[] {
							new Variable(Type.STRING, "uri")
						})
					)
				}
			)
		));
		addRule(new Rule(
			"mams.MAMSAgent", new int[] {206,9,206,141},
			new GoalEvent('+',
				new Goal(
					new Predicate("itemProperty", new Term[] {
						new Variable(Type.STRING, "artifact_name",false),
						new Variable(Type.STRING, "property",false),
						new Variable(Type.FUNCTION, "value",false)
					})
				)
			),
			new Predicate("artifact", new Term[] {
				new Variable(Type.STRING, "artifact_name"),
				new Variable(Type.STRING, "qname",false),
				new Variable(new ObjectType(cartago.ArtifactId.class), "aid",false)
			}),
			new Block(
				"mams.MAMSAgent", new int[] {206,140,209,5},
				new Statement[] {
					new ModuleCall("cartago",
						"mams.MAMSAgent", new int[] {207,8,207,91},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "aid"),
							new Funct("observeProperty", new Term[] {
								new Variable(Type.STRING, "property"),
								new Variable(new ObjectType(cartago.ArtifactObsProperty.class), "prop",false)
							})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new Assignment(
						new Variable(Type.FUNCTION, "value"),
						"mams.MAMSAgent", new int[] {208,8,209,5},
						new ModuleTerm("cartago", Type.FUNCTION,
							new Predicate("toFunction", new Term[] {
								new Variable(new ObjectType(cartago.ArtifactObsProperty.class), "prop")
							}),
							new ModuleTermAdaptor() {
								public Object invoke(Intention intention, Predicate predicate) {
									return ((astra.lang.Cartago) intention.getModule("mams.MAMSAgent","cartago")).toFunction(
										(cartago.ArtifactObsProperty) intention.evaluate(predicate.getTerm(0))
									);
								}
								public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.lang.Cartago) visitor.agent().getModule("mams.MAMSAgent","cartago")).toFunction(
										(cartago.ArtifactObsProperty) visitor.evaluate(predicate.getTerm(0))
									);
								}
							}
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
		fragment.addModule("cartago",astra.lang.Cartago.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("S",astra.lang.System.class,agent);
		fragment.addModule("F",astra.lang.Functions.class,agent);
		fragment.addModule("httpUtils",mams.HttpUtils.class,agent);
		fragment.addModule("converter",mams.JSONConverter.class,agent);
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
			astra.core.Agent agent = new MAMSAgent().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: MAMSAgent");
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

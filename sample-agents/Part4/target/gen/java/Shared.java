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

public class Shared extends ASTRAClass {
	public Shared() {
		setParents(new Class[] {mams.IntegratedInbox.class});
		addRule(new Rule(
			"Shared", new int[] {59,9,59,37},
			new GoalEvent('+',
				new Goal(
					new Predicate("form_actions", new Term[] {
						new Variable(Type.STRING, "url",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Shared", new int[] {59,36,77,5},
				new Statement[] {
					new ForEach(
						"Shared", new int[] {62,8,77,5},
						new ModuleFormula("hypermedia",
							new Predicate("Form", new Term[] {
								new Variable(Type.STRING, "url"),
								new Variable(Type.STRING, "form_id",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						),
						new Block(
							"Shared", new int[] {62,53,76,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.LIST, "required_actions"),
									"Shared", new int[] {64,12,76,9},
									new ListTerm(new Term[] {

									})
								),
								new Query(
									"Shared", new int[] {66,12,66,65},
									new ModuleFormula("hypermedia",
										new Predicate("hasTarget", new Term[] {
											new Variable(Type.STRING, "form_id"),
											new Variable(Type.STRING, "form_url",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new Query(
									"Shared", new int[] {68,12,68,63},
									new ModuleFormula("http",
										new Predicate("methodName", new Term[] {
											new Variable(Type.STRING, "form_id"),
											new Variable(Type.STRING, "http_method",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","http")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new ForEach(
									"Shared", new int[] {70,12,76,9},
									new ModuleFormula("hypermedia",
										new Predicate("properties", new Term[] {
											new Variable(Type.STRING, "form_id"),
											new Variable(Type.STRING, "propertiesId",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									),
									new Block(
										"Shared", new int[] {70,73,73,13},
										new Statement[] {
											new Query(
												"Shared", new int[] {71,16,71,74},
												new ModuleFormula("hypermedia",
													new Predicate("name", new Term[] {
														new Variable(Type.STRING, "propertiesId"),
														new Variable(Type.STRING, "requiredField",false)
													}),
													new ModuleFormulaAdaptor() {
														public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
															return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
														}
													}
												)
											),
											new Assignment(
												new Variable(Type.LIST, "required_actions"),
												"Shared", new int[] {72,16,73,13},
												Operator.newOperator('+',
													new Variable(Type.LIST, "required_actions"),
													new ListTerm(new Term[] {
														new Variable(Type.STRING, "requiredField")
													})
												)
											)
										}
									)
								),
								new BeliefUpdate('+',
									"Shared", new int[] {75,12,76,9},
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
			"Shared", new int[] {84,9,84,37},
			new GoalEvent('+',
				new Goal(
					new Predicate("link_actions", new Term[] {
						new Variable(Type.STRING, "url",false)
					})
				)
			),
			Predicate.TRUE,
			new Block(
				"Shared", new int[] {84,36,93,5},
				new Statement[] {
					new ForEach(
						"Shared", new int[] {86,8,93,5},
						new ModuleFormula("hypermedia",
							new Predicate("Link", new Term[] {
								new Variable(Type.STRING, "url"),
								new Variable(Type.STRING, "link_id",false)
							}),
							new ModuleFormulaAdaptor() {
								public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
									return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
								}
							}
						),
						new Block(
							"Shared", new int[] {86,53,92,9},
							new Statement[] {
								new Declaration(
									new Variable(Type.STRING, "link_url"),
									"Shared", new int[] {89,12,92,9},
									Primitive.newPrimitive("")
								),
								new Query(
									"Shared", new int[] {90,12,90,63},
									new ModuleFormula("hypermedia",
										new Predicate("hasTarget", new Term[] {
											new Variable(Type.STRING, "link_id"),
											new Variable(Type.STRING, "target",false)
										}),
										new ModuleFormulaAdaptor() {
											public Formula invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
												return ((astra.jena.RDFSchema) visitor.agent().getModule("Shared","hypermedia")).auto_formula((Predicate) predicate.accept(visitor));
											}
										}
									)
								),
								new BeliefUpdate('+',
									"Shared", new int[] {91,12,92,9},
									new Predicate("link_actions", new Term[] {
										new Variable(Type.STRING, "target")
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
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("system",astra.lang.System.class,agent);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("debug",astra.lang.Debug.class,agent);
		fragment.addModule("strings",astra.lang.Strings.class,agent);
		fragment.addModule("prelude",astra.lang.Prelude.class,agent);
		fragment.addModule("m",astra.lang.Math.class,agent);
		fragment.addModule("messaging",astra.lang.Messaging.class,agent);
		fragment.addModule("builder",mams.JSONBuilder.class,agent);
		fragment.addModule("converter",mams.JSONConverter.class,agent);
		fragment.addModule("httpUtils",mams.HttpUtils.class,agent);
		fragment.addModule("rdf",astra.jena.RDFSchema.class,
			new Term[] {
			Primitive.newPrimitive("http://www.w3.org/1999/02/22-rdf-syntax-ns#")
			}, agent);
		fragment.addModule("http",astra.jena.RDFSchema.class,
			new Term[] {
			Primitive.newPrimitive("http://www.w3.org/2011/http#")
			}, agent);
		fragment.addModule("hypermedia",astra.jena.RDFSchema.class,
			new Term[] {
			Primitive.newPrimitive("https://www.w3.org/2019/wot/hypermedia#")
			}, agent);
		fragment.addModule("ttt",astra.jena.RDFSchema.class,
			new Term[] {
			Primitive.newPrimitive("http://localhost:8083/tic-tac-toe#")
			}, agent);
		fragment.addModule("schema",astra.jena.RDFSchema.class,
			new Term[] {
			Primitive.newPrimitive("https://schema.org/")
			}, agent);
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
			astra.core.Agent agent = new Shared().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: Shared");
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

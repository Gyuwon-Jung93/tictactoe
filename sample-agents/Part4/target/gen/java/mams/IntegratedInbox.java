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


public class IntegratedInbox extends ASTRAClass {
	public IntegratedInbox() {
		setParents(new Class[] {MAMSAgent.class});
		addRule(new Rule(
			"mams.IntegratedInbox", new int[] {6,9,6,111},
			new GoalEvent('+',
				new Goal(
					new Predicate("created", new Term[] {
						Primitive.newPrimitive("inbox")
					})
				)
			),
			new AND(
				new NOT(
					new Predicate("have", new Term[] {
						Primitive.newPrimitive("inbox")
					})
				),
				new Predicate("artifact", new Term[] {
					Primitive.newPrimitive("base"),
					new Variable(Type.STRING, "qualifiedName",false),
					new Variable(new ObjectType(cartago.ArtifactId.class), "id2",false)
				})
			),
			new Block(
				"mams.IntegratedInbox", new int[] {6,110,15,5},
				new Statement[] {
					new Declaration(
						new Variable(Type.STRING, "baseName"),
						"mams.IntegratedInbox", new int[] {7,8,15,5},
						Operator.newOperator('+',
							new Variable(Type.STRING, "qualifiedName"),
							Primitive.newPrimitive("-inbox")
						)
					),
					new ModuleCall("cartago",
						"mams.IntegratedInbox", new int[] {9,8,9,130},
						new Predicate("makeArtifact", new Term[] {
							new Variable(Type.STRING, "baseName"),
							Primitive.newPrimitive("mams.artifacts.Inbox"),
							new ModuleTerm("cartago", new ObjectType(java.lang.Object[].class),
								new Predicate("params", new Term[] {
									new ListTerm(new Term[] {
										new ModuleTerm("adaptor", new ObjectType(mams.adaptors.InboxAdaptor.class),
											new Predicate("getInboxAdaptor", new Term[] {}),
											new ModuleTermAdaptor() {
												public Object invoke(Intention intention, Predicate predicate) {
													return ((mams.messaging.AdaptorModule) intention.getModule("mams.IntegratedInbox","adaptor")).getInboxAdaptor(
													);
												}
												public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
													return ((mams.messaging.AdaptorModule) visitor.agent().getModule("mams.IntegratedInbox","adaptor")).getInboxAdaptor(
													);
												}
											}
										)
									})
								}),
								new ModuleTermAdaptor() {
									public Object invoke(Intention intention, Predicate predicate) {
										return ((astra.lang.Cartago) intention.getModule("mams.IntegratedInbox","cartago")).params(
											(astra.term.ListTerm) intention.evaluate(predicate.getTerm(0))
										);
									}
									public Object invoke(BindingsEvaluateVisitor visitor, Predicate predicate) {
										return ((astra.lang.Cartago) visitor.agent().getModule("mams.IntegratedInbox","cartago")).params(
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
								return ((astra.lang.Cartago) intention.getModule("mams.IntegratedInbox","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.IntegratedInbox", new int[] {10,8,10,47},
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
								return ((astra.lang.Cartago) intention.getModule("mams.IntegratedInbox","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.IntegratedInbox", new int[] {11,8,11,25},
						new Predicate("focus", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.IntegratedInbox","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new ModuleCall("cartago",
						"mams.IntegratedInbox", new int[] {12,8,12,44},
						new Predicate("operation", new Term[] {
							new Variable(new ObjectType(cartago.ArtifactId.class), "id"),
							new Funct("createRoute", new Term[] {})
						}),
						new DefaultModuleCallAdaptor() {
							public boolean inline() {
								return false;
							}

							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Cartago) intention.getModule("mams.IntegratedInbox","cartago")).auto_action(intention,evaluate(intention,predicate));
							}
							public boolean suppressNotification() {
								return true;
							}
						}
					),
					new BeliefUpdate('+',
						"mams.IntegratedInbox", new int[] {14,8,15,5},
						new Predicate("artifact", new Term[] {
							Primitive.newPrimitive("inbox"),
							new Variable(Type.STRING, "baseName"),
							new Variable(new ObjectType(cartago.ArtifactId.class), "id")
						})
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("adaptor",mams.messaging.AdaptorModule.class,agent);
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
			astra.core.Agent agent = new IntegratedInbox().newInstance(name);
			if (!agent.isRunnable()) {
				java.lang.System.out.println("WARNING: No +!main(...) rule has been defined for main agent type: IntegratedInbox");
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

package com.app.jadeimplement;

import com.expertsystem.Statement;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.IOException;
import java.io.Serializable;

public class AgentClientInterface extends Agent {

    public Statement[] statements;
    public Statement goal;
    public String centralID;
    public String type;
    public boolean positive = false;
    public String result = null;
    public boolean finished = false;

    public AgentClientInterface(){
    }
    @Override
    protected void setup() {
        /*Object[] args = getArguments();
        this.statements = (Statement[]) args[0];
        this.goal = (Statement) args[1];
        this.centralID = (String) args[2];
        this.type = (String) args[3];*/
        addBehaviour(new Launch());
    }
    class Launch extends OneShotBehaviour{

        @Override
        public void action() {
            ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
            ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
            ACLMessage msg3 = new ACLMessage(ACLMessage.INFORM);
            msg1.addReceiver(new AID(centralID, true));
            msg2.addReceiver(new AID(centralID, true));
            msg3.addReceiver(new AID(centralID, true));

            msg1.setContent(type);
            try {
                msg2.setContentObject(statements);
                msg3.setContentObject(goal);
            } catch (IOException e) {
                e.printStackTrace();
            }

            send(msg1); send(msg2); send(msg3);

            msg1 = blockingReceive();
            msg2 = blockingReceive();

            try {
                positive = (boolean) msg1.getContentObject();
                result = msg2.getContent();
            } catch (UnreadableException e) {
                e.printStackTrace();
            }
            finished = true;

        }
    }
}

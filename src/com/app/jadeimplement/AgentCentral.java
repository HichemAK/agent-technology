package com.app.jadeimplement;

import com.expertsystem.Statement;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.IOException;
import java.io.Serializable;

public class AgentCentral extends Agent {
    private AID pc = null;
    private AID phone = null;
    private AID sender = null;

    public AgentCentral(){
    }
    @Override
    protected void setup() {
        Object[] args = getArguments();
        this.pc = new AID(args[0].toString(), true);
        this.phone = new AID(args[1].toString(), true);
        addBehaviour(new Launch());
    }
    class Launch extends CyclicBehaviour{

        @Override
        public void action() {
            ACLMessage msg = blockingReceive();
            String str = msg.getContent();

            sender = msg.getSender();

            msg = blockingReceive();
            Statement[] statements = null;
            try {
                statements = (Statement[]) msg.getContentObject();
            } catch (UnreadableException e) {
                e.printStackTrace();
            }

            msg = blockingReceive();
            Statement goal = null;
            try {
                goal = (Statement) msg.getContentObject();
            } catch (UnreadableException e) {
                e.printStackTrace();
            }

            ACLMessage msg2 = new ACLMessage(ACLMessage.INFORM);
            ACLMessage msg3 = new ACLMessage(ACLMessage.INFORM);
            switch(str){
                case "PC":
                    msg2.addReceiver(pc);
                    msg3.addReceiver(pc);
                    break;
                case "phone":
                    msg2.addReceiver(phone);
                    msg3.addReceiver(phone);
                    break;
            }
            try {
                msg2.setContentObject(statements);
                msg3.setContentObject(goal);
            } catch (IOException e) {
                e.printStackTrace();
            }
            send(msg2);
            send(msg3);

            msg2 = blockingReceive();
            msg3 = blockingReceive();

            ACLMessage answer1 = new ACLMessage(ACLMessage.INFORM);
            ACLMessage answer2 = new ACLMessage(ACLMessage.INFORM);

            answer1.addReceiver(sender);
            answer2.addReceiver(sender);

            try {
                answer1.setContentObject(msg2.getContentObject());
                answer2.setContent(msg3.getContent());
            } catch (IOException | UnreadableException e) {
                e.printStackTrace();
            }
            send(answer1);
            send(answer2);

        }
    }
}

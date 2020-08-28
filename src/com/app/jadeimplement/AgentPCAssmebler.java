package com.app.jadeimplement;

import com.expertsystem.ExpertSystem;
import com.expertsystem.Operation;
import com.expertsystem.Statement;
import com.expertsystem.Type;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import javafx.application.Application;
import javafx.scene.paint.Paint;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AgentPCAssmebler extends Agent
{
    ExpertSystem ES = new ExpertSystem("examples/PC.es");

    public AgentPCAssmebler() throws FileNotFoundException {
    }

    protected void setup()
    {
        addBehaviour(new Launch());
    }
    class Launch extends CyclicBehaviour {


        @Override
        public void action() {
            ACLMessage msg = blockingReceive();
            Statement[] obj = null;
            try {
                obj = (Statement[])msg.getContentObject();
            } catch (UnreadableException e) {
                e.printStackTrace();
            }
            Statement goal = null;
            msg = blockingReceive();
            try {
                goal = (Statement)msg.getContentObject();
            } catch (UnreadableException e) {
                e.printStackTrace();
            }
            AgentPCAssmebler agent = (AgentPCAssmebler) this.myAgent;
            agent.ES.clearKnowledgeBase();
            for(Statement S : obj){
                ES.addKnowledge(S);
            }
            System.out.println(ES.getKnowledgeBase());
            String result = "";
            boolean positive = false;
            if(ES.infer(goal)){
                positive = true;
                result += "Your order has been registered successfully!";
            }
            else{
                positive = false;
                result += "Sorry, we were unable to fulfill the wishes of your command:";
                Statement enough_budget = null;
                for(int i=0;i<obj.length;i++){
                    if (obj[i].getVarName().equals("enough_budget")){
                        enough_budget = obj[i];
                        break;
                    }
                }
                if(!(boolean)(enough_budget.getValue())){
                    result += "\n- Your budget is insufficient.";
                }
                try {
                    if(!ES.infer(new Statement(
                            "buildable",
                            Type.BOOLEAN,
                            Operation.EQ,
                            true
                    ))){
                        result += "\n- Your PC cannot be built.";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if(!ES.infer(new Statement(
                            "availability",
                            Type.BOOLEAN,
                            Operation.EQ,
                            true
                    ))){
                        result += "\n- One of the requested components is not available.";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ACLMessage answer = new ACLMessage(ACLMessage.INFORM);
            answer.addReceiver(msg.getSender());
            try {
                answer.setContentObject(positive);
            } catch (IOException e) {
                e.printStackTrace();
            }
            send(answer);
            answer = new ACLMessage(ACLMessage.INFORM);
            answer.addReceiver(msg.getSender());
            answer.setContent(result);
            send(answer);
            System.out.println(ES.getKnowledgeBase());
        }
    }
}

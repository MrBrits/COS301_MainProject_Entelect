package za.co.tera.web_ca.domain.impl;

/**
 * Created by Stephan on 9/25/2014.
 */
public class RuleEncapsulate {
    Rule rule= new Rule();
    Rulecondition ruleCond=new Rulecondition();
    Rulecondition ruleCondAND=new Rulecondition();
    Rulecondition ruleCondOR=new Rulecondition();
    Ruleresult ruleresult=new Ruleresult();

    public RuleEncapsulate(String String) {

        String [] arr = String.split(";");
        for (int i = 0; i < arr.length; i++) {
            if(!test(arr[i]))
            {
                System.out.println("Incorrect Syntax");
            }

        }
    }
    public boolean test(String s)
    {
        //System.out.print(s);
        String value = s.split(":=")[1];
        if(s.contains("ruleName"))
        {
            rule.setRuleName(value);
        }
        else if(s.contains("ruleDesc"))
        {
            rule.setRuleDesc(value);
        }
        else if(s.contains("ruleCond.isNot"))
        {
            ruleCond.setNot(value.equals("true"));
        }
        else if(s.contains("ruleCond.conOperation"))
        {
            ruleCond.setOperation(value);
        }
        else if(s.contains("ruleCond.conOperand"))
        {
            ruleCond.setOperand(value);
        }
        else if(s.contains("ruleCond.compareValueOne"))
        {
            ruleCond.setCompareValueOne(Double.parseDouble(value));
        }
        else if(s.contains("ruleCond.compareValueTwo"))
        {
            ruleCond.setCompareValueTwo(Double.parseDouble(value));
        }
        else if(s.contains("ruleCondAND.isNot"))
        {
            ruleCondAND.setNot(value.equals("true"));
        }
        else if(s.contains("ruleCondAND.conOperation"))
        {
            ruleCondAND.setOperation(value);
        }
        else if(s.contains("ruleCondAND.conOperand"))
        {
            ruleCondAND.setOperand(value);
        }
        else if(s.contains("ruleCondAND.compareValueOne"))
        {
            ruleCondAND.setCompareValueOne(Double.parseDouble(value));
        }
        else if(s.contains("ruleCondAND.compareValueTwo"))
        {
            ruleCondAND.setCompareValueTwo(Double.parseDouble(value));
        }
        else if(s.contains("ruleCondOR.isNot"))
        {
            ruleCondOR.setNot(value.equals("true"));
        }
        else if(s.contains("ruleCondOR.conOperation"))
        {
            ruleCondOR.setOperation(value);
        }
        else if(s.contains("ruleCondOR.conOperand"))
        {
            ruleCondOR.setOperand(value);
        }
        else if(s.contains("ruleCondOR.compareValueOne"))
        {
            ruleCondOR.setCompareValueOne(Double.parseDouble(value));
        }
        else if(s.contains("ruleCondOR.compareValueTwo"))
        {
            ruleCondOR.setCompareValueTwo(Double.parseDouble(value));
        }
        else if(s.contains("Operation"))
        {
            ruleresult.setOperation(value);
        }
        else if(s.contains("resultValue"))
        {
            ruleresult.setResultValue(Double.parseDouble(value));
        }
        else
            return false;

        return true;

    }
    public Rule getRule()
    {
        return rule;
    }
    public Rulecondition getCond()
    {
        return ruleCond;
    }
    public Rulecondition getCondAND()
    {
        return ruleCondAND;
    }
    public Rulecondition getCondOR()
    {
        return ruleCondOR;
    }

}


        /*+

         name=GameOfLifeRule1;
         ruleDesc=Under Population;


         ruleArray[0].ruleDesc = "";
        +    ruleArray[0].enabled = true;
        +
        +    ruleArray[0].ruleCond = new condition();
        +    ruleArray[0].ruleCond.isNot = false;
        +    ruleArray[0].ruleCond.conditionOperation = "SUM";
        +    ruleArray[0].ruleCond.conditionNeighbours = "000000000000010000000000000";
        +    ruleArray[0].ruleCond.conditionOperand = "==";
        +    ruleArray[0].ruleCond.compareValueOne = 1;
        +    ruleArray[0].ruleCond.compareValueTwo = null;
        +
        +    ruleArray[0].RuleCondAND = new condition();
        +    ruleArray[0].RuleCondAND.isNot = false;
        +    ruleArray[0].RuleCondAND.conditionOperation = "SUM";
        +    ruleArray[0].RuleCondAND.conditionNeighbours = "111111111111101111111111111";
        +    ruleArray[0].RuleCondAND.conditionOperand = "<";
        +    ruleArray[0].RuleCondAND.compareValueOne = 2;
        +    ruleArray[0].RuleCondAND.compareValueTwo = null;
        +
        +    ruleArray[0].resultOperand = "";
        +    ruleArray[0].resultOperator = "";
        +    ruleArray[0].resultValue = 0;*/
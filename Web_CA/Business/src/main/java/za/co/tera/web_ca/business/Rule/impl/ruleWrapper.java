package za.co.tera.web_ca.business.Rule.impl;

import com.google.gson.Gson;
import groovy.lang.GroovyShell;
import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.domain.impl.Rule;
import za.co.tera.web_ca.domain.impl.Rulecondition;
import za.co.tera.web_ca.domain.impl.Ruleneighbours;
import za.co.tera.web_ca.domain.impl.Ruleresult;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//  runner.condition("when true sum of 1;4:8 between 1 3");
//  runner.condition("then sum of 1;4:8 = 1");
// runner.condition("identifiedBy rule1 fdfdf");
public class ruleWrapper {
    String NeighbourString = "000000000000000000000000000";
    int rulecond=-1;
    int rulecondOR=-1;
    int rulecondAND=-1;
    int ruleresult=-1;
    int ruleneighboursCond=-1;
    int ruleneighboursAND=-1;
    int ruleneighboursOR=-1;
    int ruleneighbours_Result=-1;
    RuleService ruleService= new RuleServiceImpl();
    public ruleWrapper()
    {

    }

     void runWithGroovyShell(String[] ars, String type,String _subtype) throws Exception {

        Object tempObject = new GroovyShell().parse(new File("Business/src/main/java/za/co/tera/web_ca/business/Rule/impl/ruleDsl.groovy")).invokeMethod(type, ars);
        Gson gson = new Gson();
        String jsonString = gson.toJson(tempObject);
        System.out.println(_subtype);
        if(type.equals("when"))
        {
            tempObject = gson.fromJson(jsonString, Rulecondition.class);
            Rulecondition rulecondition = (Rulecondition) tempObject;
            if(_subtype.equals("when")) {
                rulecondition.setNeighboursId(ruleneighboursCond);
                rulecond = ruleService.createRuleCon(rulecondition);
            }
            else if(_subtype.equals("and")) {
                rulecondition.setNeighboursId(ruleneighboursAND);
                rulecondAND = ruleService.createRuleCon(rulecondition);
            }
            else if(_subtype.equals("or")) {
                rulecondition.setNeighboursId(ruleneighboursOR);
                rulecondOR = ruleService.createRuleCon(rulecondition);
            }
        }
        else if(type.equals("neighours"))
        {
            tempObject = gson.fromJson(jsonString, Ruleneighbours.class);
            Ruleneighbours ruleneighbours = (Ruleneighbours) tempObject;
            if(_subtype.equals("when"))
            {
                ruleneighboursCond=ruleService.createRuleNeigh(ruleneighbours);
            }
            if(_subtype.equals("and"))
            {
                ruleneighboursAND=ruleService.createRuleNeigh(ruleneighbours);
            }
            if(_subtype.equals("or"))
            {
                ruleneighboursOR=ruleService.createRuleNeigh(ruleneighbours);
            }
            if(_subtype.equals("then"))
            {
                ruleneighbours_Result=ruleService.createRuleNeigh(ruleneighbours);
            }
        }
        else if(type.equals("then"))
        {
            tempObject = gson.fromJson(jsonString, Ruleresult.class);
            Ruleresult ruleresults = (Ruleresult) tempObject;
            ruleresults.setNeighboursId(ruleneighbours_Result);
            ruleresult=ruleService.createRuleRes(ruleresults);

        }
        else if(type.equals("identifiedBy"))
        {
            tempObject = gson.fromJson(jsonString, Rule.class);
            Rule rule = (Rule) tempObject;
            rule.setOwnerId(11118);
            rule.setRuleResId(ruleresult);
            rule.setRuleConId(rulecond);
            if(ruleneighboursAND!=-1)
                rule.setRuleConAndid(rulecondAND);
            else
                rule.setRuleConAndid(null);
            if(ruleneighboursOR!=-1)
                rule.setRuleConOrid(rulecondOR);
            else
                rule.setRuleConOrid(null);
            ruleService.createRule(rule);
            rulecond=-1;
            rulecondOR=-1;
            rulecondAND=-1;
            ruleresult=-1;
            ruleneighboursCond=-1;
            ruleneighboursAND=-1;
            ruleneighboursOR=-1;
            ruleneighbours_Result=-1;
        }

    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    String subType;
    public void condition(String input) throws Exception {
        NeighbourString = "000000000000000000000000000";
        List<String> arr = new LinkedList<String>();
        StringTokenizer st = new StringTokenizer(input, " ");
        while (st.hasMoreTokens()) {
            NeighbourString = "000000000000000000000000000";
            String temp = st.nextToken();
            subType=temp;
            if (temp.equals("when") || temp.equals("and") || temp.equals("or")) {
                temp = st.nextToken();
                if (temp.contains("true") || temp.contains("false")) {
                    arr.add(temp);
                } else {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                if (temp.contains("sum") || temp.contains("avg") || temp.contains("min") || temp.contains("max") || temp.contains("count")) {
                    arr.add(temp);
                } else {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                if (!temp.contains("of")) {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                String[] h = temp.split(";");
                for (int i = 0; i < h.length; i++) {

                    if (h[i].contains(":")) {

                        NeighbourString = returnNeighbour(Integer.parseInt(h[i].split(":")[0]) - 1, Integer.parseInt(h[i].split(":")[1]));
                    } else if (isNumeric(h[i])) {
                        NeighbourString = returnNeighbour(Integer.parseInt(h[i]) - 1, Integer.parseInt(h[i]));

                    } else {
                        System.out.println("Incorrect Syntax");
                        return;
                    }


                }
                String[] ars = {NeighbourString};
                runWithGroovyShell(ars, "neighours",subType);

                temp = st.nextToken();
                if (temp.contains("<") || temp.contains(">") || temp.contains(">=") || temp.contains("<=") || temp.contains("==") || temp.contains("between")) {
                    arr.add(temp);
                    if (temp.contains("between")) {
                        temp = st.nextToken();
                        if (isNumeric(temp))
                            arr.add(temp);
                        else {
                            System.out.println("Incorrect Syntax");
                            return;
                        }
                        temp = st.nextToken();
                        if (isNumeric(temp))
                            arr.add(temp);
                        else {
                            System.out.println("Incorrect Syntax");
                            return;
                        }
                    } else {

                        temp = st.nextToken();
                        if (isNumeric(temp)) {
                            arr.add(temp);
                            arr.add("");
                        } else {
                            System.out.println("Incorrect Syntax");
                            return;
                        }
                    }
                } else {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                ars = new String[arr.size()];
                for (int i = 0; i < arr.size(); i++) {
                    ars[i] = arr.get(i);
                }
                arr.clear();
                runWithGroovyShell(ars, "when",subType);
            } else if (temp.equals("then")) {

                temp = st.nextToken();
                if (temp.contains("sum") || temp.contains("avg") || temp.contains("min") || temp.contains("max") || temp.contains("count") || temp.contains("exact")) {
                    arr.add(temp);
                } else {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                if (!temp.contains("of")) {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                String[] h = temp.split(";");
                for (int i = 0; i < h.length; i++) {

                    if (h[i].contains(":")) {

                        NeighbourString = returnNeighbour(Integer.parseInt(h[i].split(":")[0]) - 1, Integer.parseInt(h[i].split(":")[1]));
                    } else if (isNumeric(h[i])) {
                        NeighbourString = returnNeighbour(Integer.parseInt(h[i]) - 1, Integer.parseInt(h[i]));
                        // Number is integer
                    } else {
                        System.out.println("Incorrect Syntax");
                        return;
                    }


                }

                String[] ars = {NeighbourString};
                runWithGroovyShell(ars, "neighours",subType);
                temp = st.nextToken();
                if (!temp.contains("=")) {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                temp = st.nextToken();
                if (isNumeric(temp)) {
                    arr.add(temp);

                } else {
                    System.out.println("Incorrect Syntax");
                    return;
                }
                ars = new String[arr.size()];
                for (int i = 0; i < arr.size(); i++) {
                    ars[i] = arr.get(i);

                }
                runWithGroovyShell(ars, "then",subType);
            } else if (temp.equals("identifiedBy")) {
                String ars[] = new String[2];
                temp = st.nextToken();
                ars[0] = temp;
                temp = st.nextToken();
                ars[1] = temp;

                runWithGroovyShell(ars, "identifiedBy",subType);
            }

        }

    }

    public String returnNeighbour(int begin, int end) {
        for (int i = begin; i < end; i++) {
            char[] myNameChars = NeighbourString.toCharArray();
            myNameChars[i] = '1';
            NeighbourString = String.valueOf(myNameChars);
        }
        return NeighbourString;
    }
}
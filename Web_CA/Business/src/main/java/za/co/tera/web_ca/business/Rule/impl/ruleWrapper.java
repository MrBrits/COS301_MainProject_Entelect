package za.co.tera.web_ca.business.Rule.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

        Object tempObject = new GroovyShell().parse(new File("ruleDsl.groovy")).invokeMethod(type, ars);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String jsonString = gson.toJson(tempObject);
        //System.out.println(jsonString);
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
            if(ruleneighbours_Result!=-1)
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
        System.out.println(input);
        NeighbourString = "000000000000000000000000000";
        List<String> arr = new LinkedList<String>();
        StringTokenizer st = new StringTokenizer(input, " ");
        while (st.hasMoreTokens()) {

            NeighbourString = "000000000000000000000000000";
            String temp = st.nextToken();
            if(temp.toLowerCase().equals("if"))
                subType="when";
            else
                subType = temp.toLowerCase();

            temp = temp.toUpperCase();

            if (temp.equals("IF") || temp.equals("AND") || temp.equals("OR")) {

                temp = st.nextToken().toUpperCase();
                if (temp.equals("TRUE") || temp.equals("FALSE")) {
                    arr.add(temp);
                } else {
                    System.out.println("Incorrect Syntax1");
                    return;
                }
                temp = st.nextToken().toUpperCase();
                if (temp.equals("SUM") || temp.equals("AVG") || temp.equals("MIN") || temp.equals("MAX") || temp.equals("COUNT")) {
                    arr.add(temp);
                } else {
                    System.out.println("Incorrect Syntax2");
                    return;
                }
                temp = st.nextToken().toUpperCase();
                if (!temp.equals("OF")) {
                    System.out.println("Incorrect Syntax3");
                    return;
                }
                temp = st.nextToken().toUpperCase();
                String[] h = temp.split(";");
                for (int i = 0; i < h.length; i++) {

                    if (h[i].contains(":")) {

                        NeighbourString = returnNeighbour(Integer.parseInt(h[i].split(":")[0]) - 1, Integer.parseInt(h[i].split(":")[1]));
                    } else if (isNumeric(h[i])) {
                        NeighbourString = returnNeighbour(Integer.parseInt(h[i]) - 1, Integer.parseInt(h[i]));

                    } else {
                        System.out.println("Incorrect Syntax4");
                        return;
                    }


                }
                String[] ars = {NeighbourString};
                runWithGroovyShell(ars, "neighours", subType);

                temp = st.nextToken().toUpperCase();

                if (temp.equals("<") || temp.equals(">") || temp.equals(">=") || temp.equals("<=") || temp.equals("==") || temp.equals("BI")|| temp.equals("BE")) {
                    arr.add(temp);
                    if ( temp.equals("BI")|| temp.equals("BE")) {
                        temp = st.nextToken().toUpperCase();
                        if (isNumeric(temp))
                            arr.add(temp);
                        else {
                            System.out.println("Incorrect Syntax5");
                            return;
                        }
                        temp = st.nextToken().toUpperCase();
                        if (isNumeric(temp))
                            arr.add(temp);
                        else {
                            System.out.println("Incorrect Syntax6");
                            return;
                        }
                    } else {

                        temp = st.nextToken().toUpperCase();
                        if (isNumeric(temp)) {
                            arr.add(temp);
                            arr.add(null);
                        } else {
                            System.out.println("Incorrect Syntax7");
                            return;
                        }
                    }
                } else {
                    System.out.println("Incorrect Syntax8");
                    return;
                }
                ars = new String[arr.size()];
                for (int i = 0; i < arr.size(); i++) {
                    ars[i] = arr.get(i);
                }
                arr.clear();
                runWithGroovyShell(ars, "when", subType);
            }

            //THEN===================================================
            else if (temp.equals("THEN")) {

                temp = st.nextToken().toUpperCase();
                if(temp.equals("="))
                {
                    arr.add(null);
                    temp = st.nextToken().toUpperCase();
                    if(isNumeric(temp))
                        arr.add(temp);
                    else {
                        System.out.println("Incorrect Syntax9");
                        return;
                    }

                }
                else {
                    if (temp.equals("SUM") || temp.equals("AVG") || temp.equals("MIN") || temp.equals("MAX") || temp.equals("COUNT")) {
                        arr.add(temp);
                    } else {
                        System.out.println("Incorrect Syntax10");
                        return;
                    }
                    temp = st.nextToken().toUpperCase();
                    if (!temp.equals("OF")) {
                        System.out.println("Incorrect Syntax11");
                        return;
                    }
                    temp = st.nextToken().toUpperCase();
                    String[] h = temp.split(";");
                    for (int i = 0; i < h.length; i++) {

                        if (h[i].contains(":")) {

                            NeighbourString = returnNeighbour(Integer.parseInt(h[i].split(":")[0]) - 1, Integer.parseInt(h[i].split(":")[1]));
                        } else if (isNumeric(h[i])) {
                            NeighbourString = returnNeighbour(Integer.parseInt(h[i]) - 1, Integer.parseInt(h[i]));
                            // Number is integer
                        } else {
                            System.out.println("Incorrect Syntax12");
                            return;
                        }


                    }

                    String[] ars = {NeighbourString};
                    runWithGroovyShell(ars, "neighours", subType);
                    if(st.hasMoreTokens())
                    {
                        System.out.println("Incorrect Syntax13: "+temp);
                    }
                    else
                    {
                        arr.add(null);
                    }

                }
                String [] ars = new String[arr.size()];
                for (int i = 0; i < arr.size(); i++) {
                    ars[i] = arr.get(i);

                }
                runWithGroovyShell(ars, "then", subType);
            } else if (temp.equals("IDENTIFIEDBY")) {
                String ars[] = new String[2];
                temp = st.nextToken();
                ars[0] = temp;
                ars[1] ="";
                while (st.hasMoreTokens()) {
                    temp = st.nextToken();
                    ars[1] +=" "+ temp;
                }
                runWithGroovyShell(ars, "identifiedBy", subType);
            }
            else
            {
                System.out.println("Incorrect Syntax16: "+temp);

            }

        }}

    public String returnNeighbour(int begin, int end) {
        for (int i = begin; i < end; i++) {
            char[] myNameChars = NeighbourString.toCharArray();
            myNameChars[i] = '1';
            NeighbourString = String.valueOf(myNameChars);
        }
        return NeighbourString;
    }
}
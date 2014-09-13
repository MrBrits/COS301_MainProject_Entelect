//Rule Class used to contain all of the information about a rule
function rule()	{
    //Rule Metadata
    this.ruleName = "";
    this.ruleDesc = "";
    this.enabled = false;
    //Condition
    this.ruleCond = null;
    this.RuleCondAND = null;
    this.RuleCondOR = null;

    //Result of Rule
    this.resultOperand = "";
    this.resultOperator = "";
    this.resultNeighbours = "000000000000000000000000000";
    this.resultValue = 0;
}

function condition()	{
    //Rule Condition
    this.isNot = false;
    this.conditionOperation = "";
    this.conditionNeighbours = "000000000000000000000000000";
    this.conditionOperand = "";
    this.compareValueOne = 0;
    this.compareValueTwo = 0;
}
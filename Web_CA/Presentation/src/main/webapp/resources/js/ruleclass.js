//Rule Class used to contain all of the information about a rule
function rule()	{
    //Variables
    this.numConditions = 0;

    //Rule Metadata
    this.ruleName = "";
    this.ruleDesc = "";
    this.priority = 0;

    //Condition Array
    this.conditionArray = new Array();

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
    this.conditionOperandSecondary = "";
    this.compareValue = 0;
    this.compareValueHigh = 0;
    this.logicalOperationPrevious = "";
}
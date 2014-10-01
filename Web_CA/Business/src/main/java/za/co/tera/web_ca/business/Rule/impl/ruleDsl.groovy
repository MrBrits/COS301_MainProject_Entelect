

class RuleCondition implements Serializable {
    def isNot
    def operation
    def operand
    def compareValueOne
    def compareValueTwo
}
def when(_isNot, _Operation,_Operand,_CompareValueOne,_CompareValueTwo) {
    def ruleCond = new RuleCondition(isNot: _isNot,operation: _Operation, operand: _Operand, compareValueOne: _CompareValueOne, compareValueTwo: _CompareValueTwo)
    return ruleCond
}


class RuleResult implements Serializable{
    def operation
    def resultValue
}
def then(_Operation,_ResultValue)
{
    def ruleResult = new RuleResult(operation: _Operation, resultValue: _ResultValue,)
    return ruleResult
}


class RuleInfo implements Serializable {
    def ruleName
    def ruleDesc
}
def identifiedBy(_RuleName,_RuleDesc)
{
    def ruleInfo = new RuleInfo(ruleName: _RuleName,ruleDesc: _RuleDesc)
    return ruleInfo
}



class RuleNeighbours implements Serializable {
    def neighbours
}
def neighours(_Neighbours)
{
    def ruleNeighbours = new RuleNeighbours(neighbours: _Neighbours)
    return ruleNeighbours
}
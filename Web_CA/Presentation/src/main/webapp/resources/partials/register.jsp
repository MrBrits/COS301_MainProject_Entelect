
<div class="container marketing">
    <div class="row">
        <div class="panel-group navbar-left col-md-4" id="accordion">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#state">
                            States
                        </a>
                    </h4>
                </div>
                <div id="state" class="panel-collapse collapse">
                    <div ng-controller="StateGetCtr">
                        <input class="form-control" placeholder="Search State" ng-model="search.stateName"/>
                        <table class="table">
                            <tr ng-repeat="state in states | filter:search">
                                <td><button type="button" ng-style="{'background-color':state.stateRgb}" class="btn btn-default btn-lg" ></button> <label>{{state.stateName}}</label><br>
                                    <p>{{state.stateDesc}}</p>  </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#rule">
                            Rules
                        </a>
                    </h4>
                </div>
                <div id="rule" class="panel-collapse collapse">
                    <div ng-controller="RuleGetCtr">
                        <input class="form-control" placeholder="Search Rule" ng-model="search.ruleName"/>
                        <table class="table">
                            <tr ng-repeat="rule in rules | filter:search">
                                <td><button type="button" class="btn btn-default btn-lg" ></button> <label>{{rule.ruleName}}</label><br>
                                    <p>{{rule.ruleDesc}}</p>  </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#world">
                            Worlds
                        </a>
                    </h4>
                </div>
                <div id="world" class="panel-collapse collapse">
                    <div ng-controller="WorldGetCtr">
                        <input class="form-control" placeholder="Search World" ng-model="search.worldName"/>
                        <table class="table">
                            <tr ng-repeat="world in worlds | filter:search">
                                <td><button type="button" class="btn btn-default btn-lg" ></button> <label>{{world.worldName}}</label><br>
                                    <p>{{world.worldDesc}}</p>  </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="[ col-xs-12 col-sm-offset-1 col-sm-5 ]">
                    <div class="[ panel panel-default ] panel-google-plus">
                        <div class="dropdown">
                    <span class="dropdown-toggle" type="button" data-toggle="dropdown">
                        <span class="[ glyphicon glyphicon-chevron-down ]"></span>
                    </span>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
                            </ul>
                        </div>
                        <div class="panel-google-plus-tags">
                            <ul>
                                <li>#NiceWorld</li>
                                <li>#EpicRule</li>
                            </ul>
                        </div>
                        <div class="panel-heading">
                            <img class="[ img-circle pull-left ]" src="https://lh3.googleusercontent.com/-CxXg7_7ylq4/AAAAAAAAAAI/AAAAAAAAAQ8/LhCIKQC5Aq4/s46-c-k-no/photo.jpg" alt="Mouse0270" />
                            <h3>John Temp</h3>
                            <h5><span>Shared publicly</span> - <span>Jun 14, 2014</span> </h5>
                        </div>
                        <div class="panel-body">
                            <p>Thank you for sharing, nicely done</p>
                        </div>
                        <div class="panel-footer">
                            <button type="button" class="[ btn btn-default ]">+1</button>
                            <button type="button" class="[ btn btn-default ]">
                                <span class="[ glyphicon glyphicon-share-alt ]"></span>
                            </button>
                            <div class="input-placeholder">Add a comment...</div>
                        </div>
                        <div class="panel-google-plus-comment">
                            <img class="img-circle" src="https://lh3.googleusercontent.com/uFp_tsTJboUY7kue5XAsGA=s46" alt="za.co.tera.Business.User Image" />
                            <div class="panel-google-plus-textarea">
                                <textarea rows="4"></textarea>
                                <button type="submit" class="[ btn btn-success disabled ]">Post comment</button>
                                <button type="reset" class="[ btn btn-default ]">Cancel</button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/LloydsBank.feature");
formatter.feature({
  "name": "Contact",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@LloydsBank"
    }
  ]
});
formatter.scenario({
  "name": "Careers selection",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@LloydsBank"
    },
    {
      "name": "@Scenario1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I launch the website",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonStepDefinitions.iLaunchTheWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the apply now button",
  "keyword": "When "
});
formatter.match({
  "location": "CommonStepDefinitions.iClickTheApplyNowButton()"
});
formatter.result({
  "status": "passed"
});
});
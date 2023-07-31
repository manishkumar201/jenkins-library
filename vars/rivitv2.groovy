void call (Map input) {
	this.action = input.action ?: "build";
	assert action instanceof String : "action should be a String, the current type is ${action.getClass()}";
	this.event = input.event ?: "failure";
	assert event instanceof String : "event should be a String, the current type is ${event.getClass()}";
	this.branch = input.branch ?: "";
	assert branch instanceof String : "branch should be a String, the current type is ${branch.getClass()}";
	this.slackChannel = input.slackChannel ?: "";
	assert slackChannel instanceof String : "channel should be a String, the current type is ${slackChannel.getClass()}";

	String color = "danger";
    // String message = "message for slack";
	// this.message = input.message ?: "";
    // assert message instanceof String : "channel should be a String, the current type is ${message.getClass()}";

    this.BUILD_NUMBER = input.BUILD_NUMBER;
	this.BUILD_TIMESTAMP = input.BUILD_TIMESTAMP;
	this.JOB_NAME = input.JOB_NAME;
	this.failed = input.failed;
	this.name = input.name;
	this.BUILD_URL = input.BUILD_URL;
    this.message = """ Hi Team, 
	Details of the test failure are as follows: Test Execution ID: `${BUILD_NUMBER}`""";

    
	slackSend channel: slackChannel, color: color, message: message;
}

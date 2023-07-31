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

    this.BUILD_NUMBER = input.BUILD_NUMBER ?: "";
    assert BUILD_NUMBER instanceof String : "channel should be a String, the current type is ${BUILD_NUMBER.getClass()}";

	this.BUILD_TIMESTAMP = input.BUILD_TIMESTAMP ?: "";
    assert BUILD_TIMESTAMP instanceof String : "channel should be a String, the current type is ${BUILD_TIMESTAMP.getClass()}";

	this.JOB_NAME = input.JOB_NAME ?: "";
    assert JOB_NAME instanceof String : "channel should be a String, the current type is ${JOB_NAME.getClass()}";

	this.failed = input.failed ?: "";
    assert failed instanceof String : "channel should be a String, the current type is ${failed.getClass()}";

	this.name = input.name ?: "";
    assert name instanceof String : "channel should be a String, the current type is ${name.getClass()}";

	this.BUILD_URL = input.BUILD_URL ?: "";
    assert BUILD_URL instanceof String : "channel should be a String, the current type is ${BUILD_URL.getClass()}";

    this.message = "
            Hi Team,
            
            Details of the test failure are as follows:
            Test Execution ID: `${BUILD_NUMBER}`
            Test Start Date: `${BUILD_TIMESTAMP}`
            Failed Job: `${JOB_NAME}`
            Failed Test Count: `${failed}`
            Failed Tests: `${name}`
            Failed URL: `${BUILD_URL}`
            ";


	slackSend channel: slackChannel, color: color, message: message;
}

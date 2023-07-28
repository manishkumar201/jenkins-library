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
	String message = "The pipeline `${currentBuild.fullDisplayName}` failed. Head out to Jenkins at ${BUILD_URL}console to see what's up!!!" ;
//new comment
	if (branch) {
		switch (event) {
			case 'start':
				color = "warning";
				message =  "The pipeline `${currentBuild.fullDisplayName}` has started off the `${branch}` branch."
				break;
			case 'stop':
				color = "good";
				message = "The pipeline `${currentBuild.fullDisplayName}` completed successfully off the `${branch}` branch. Results at ${BUILD_URL}console";
				break;
			default:
				break;
		}
	}
	else {
		switch (event) {
			case 'start':
				color = "warning";
				message =  "The pipeline `${currentBuild.fullDisplayName}` has started"
				break;
			case 'stop':
				color = "good";
				message = "The pipeline `${currentBuild.fullDisplayName}` completed successfully. Results at ${BUILD_URL}console";
				break;
			default:
				break;
		}
	}
	slackSend channel: slackChannel, color: color, message: message;
}

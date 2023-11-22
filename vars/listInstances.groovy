List call() {
  def command = 'aws ec2 describe-instances --query Reservations[*].Instances[*].InstanceId --output text'
  
  // Run the command and capture the output
  def instanceIdsString = sh(script: command, returnStdout: true).trim()

  // Tokenize the output to create a list of instance IDs
  def instanceIds = instanceIdsString.tokenize()
  
  return instanceIds
}

List call() {
  def command = '''aws ec2 describe-instances --query 'Reservations[*].Instances[*].InstanceId' --output text'''
  def process = command.execute()
  process.waitFor()

  def instanceIds = []
  process.text.getText().eachLine { line ->
    instanceIds.addAll(line.tokenize())
  }
  return instanceIds
}

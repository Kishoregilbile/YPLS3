pipeline 
{
	agent any
	stages
	{
		stage ('Compile Stage')
		{
			steps
			{
				withMaven(maven : '3.5.3')
				{
					sh 'mvn clean compile'
				}
			}
		}
		
		stage ('Testing Stage')
		{
			steps
			{
				withMaven(maven : '3.5.3')
				{
					sh 'mvn test'
				}
			}
		}
		
	}
}
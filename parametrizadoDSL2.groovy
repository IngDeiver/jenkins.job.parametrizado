job('ejemplo-job-dsl') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/IngDeiver/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('ingDeiver')
        		node / gitConfigEmail('ingendeiver@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		githubPush()
    	}
  	steps {
    		shell("sh jobscript.sh")
    	}
  	publishers {
      		mailer('ingendeiver@gmail.com', true, true)
    	}
}

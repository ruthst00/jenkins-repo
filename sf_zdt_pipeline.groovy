import groovy.util.ConfigSlurper

pipeline {
    agent any

    stages {
        def props = getProperties()
        echo "Deploying SF '${props.appvers}' ZDT phase: '${props.zdtphase}' phase for client: '${props.hhrr}', environment: '${props.datamode}'"

        stage('stage') {
            steps {
              def props = getProperties()
              echo "Deploying SF '${props.appvers}' ZDT phase: '${props.zdtphase}' phase for client: '${props.hhrr}', environment: '${props.datamode}'"
            }
        }
        stage('cutover') {
            steps {
              def props = getProperties()
              echo "Deploying SF '${props.appvers}' ZDT phase: '${props.zdtphase}' phase for client: '${props.hhrr}', environment: '${props.datamode}'"
            }
        }
        stage('post_cutover') {
            steps {
              def props = getProperties()
              echo "Deploying SF '${props.appvers}' ZDT phase: '${props.zdtphase}' phase for client: '${props.hhrr}', environment: '${props.datamode}'"
            }
        }
    }

    post {
        always {
            // TODO
        }
        failure {
            mail to: stephen.rutherford@cerner.com, subject: "The SF ZDT Pipeline failed for SF '${appvers}' ZDT phase: '${zdtphase}' phase for client: '${hhrr}', environment: '${datamode}'"
        }
    }

    // Get hashmap of properties for this deployment
    def getProperties() {
      def props = new ConfigSlurper().parse(new File('sf_zdt_pipeline.properties').toURL
      return props
    }
}

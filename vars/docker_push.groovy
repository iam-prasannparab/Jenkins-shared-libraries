def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'DockerHubPass', usernameVariable: 'DockerHubUser')]) {
      sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}

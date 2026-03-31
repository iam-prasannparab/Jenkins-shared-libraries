def call(String Project, String ImageTag) {

    withCredentials([usernamePassword(
        credentialsId: 'DockerHubCred',
        usernameVariable: 'USER',
        passwordVariable: 'PASS'
    )]) {

        sh """
        echo $PASS | docker login -u $USER --password-stdin
        docker tag ${Project}:${ImageTag} $USER/${Project}:${ImageTag}
        docker push $USER/${Project}:${ImageTag}
        """
    }
}

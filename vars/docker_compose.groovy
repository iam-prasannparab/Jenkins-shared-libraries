def call() {
    sh "docker compose down || true"
    sh "docker compose up -d"
}

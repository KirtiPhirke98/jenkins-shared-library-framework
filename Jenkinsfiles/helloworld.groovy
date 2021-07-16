@Library('dcube-library@master') _

pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'HelloWorld testing'
                echo "Into Umbrella360 Build"
        checkout([$class: 'GitSCM', branches: [[name: 'feature/docker-build']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'umbrella360']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'Bitbucket_Sevice_Account', url: 'https://bitbucket.org/tarionwarranty/umbrella360.git']]])
        treeMapData = git(branch: 'feature/docker-build', credentialsId: 'Bitbucket_Sevice_Account', url: 'https://bitbucket.org/tarionwarranty/umbrella360.git')
        u360_commit = treeMapData["GIT_COMMIT"]
        echo "commitId -> $u360_commit"
            }
        }
    }
}

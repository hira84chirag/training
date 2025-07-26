node {
    options {
        skipDefaultCheckout()  true
    }
    stage('No Checkout Stage') {
        echo 'This stage runs without a default SCM checkout.'
         Custom logic here
    }
     If you need to checkout later
    stage('Manual Checkout Stage') {
        checkout scm
    }
}

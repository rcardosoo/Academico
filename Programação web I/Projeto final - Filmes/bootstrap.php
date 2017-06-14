<?php
// bootstrap.php
require_once "vendor/autoload.php";

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

//$paths = array("/src/model");
$isDevMode = true;

// the connection configuration
$dbParams = array(
    'driver'   => 'pdo_mysql',
    'user'     => 'root',
    'password' => 'rafa1995',
    'dbname'   => 'filme2bd',
);

$config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src/model"), $isDevMode);
$entityManager = EntityManager::create($dbParams, $config);
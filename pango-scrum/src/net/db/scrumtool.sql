-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 04 Avril 2014 à 15:06
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `scrumtool`
--

-- --------------------------------------------------------

--
-- Structure de la table `collaborator`
--

CREATE TABLE IF NOT EXISTS `collaborator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `administrator` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `collaborator`
--

INSERT INTO `collaborator` (`id`, `login`, `password`, `firstname`, `lastname`, `email`, `administrator`) VALUES
(1, 'jcheron', 'jcheron', 'Jean-Christophe', 'HERON', 'myaddressmail@gmail.com', 1),
(2, 'girod', 'girod', 'Pénélope', 'GIROD', 'PGirod@sts-sio-caen.info', 0),
(4, 'admin', 'admin', 'admin', 'admin', 'admin@admin.com', 1);

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `dateComment` datetime DEFAULT NULL,
  `idUserStory` int(11) NOT NULL,
  `idCommentType` int(11) DEFAULT NULL,
  `idCollaborator` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Comment_userStory1_idx` (`idUserStory`),
  KEY `fk_Comment_Collaborator1_idx` (`idCollaborator`),
  KEY `fk_Comment_CommentType1_idx` (`idCommentType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commenttype`
--

CREATE TABLE IF NOT EXISTS `commenttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `defaultContent` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSprint` int(11) NOT NULL,
  `idEventType` int(11) NOT NULL,
  `eventDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_event_Sprint_idx` (`idSprint`),
  KEY `fk_event_eventType1_idx` (`idEventType`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `event`
--

INSERT INTO `event` (`id`, `idSprint`, `idEventType`, `eventDate`) VALUES
(1, 1, 1, '2014-01-14'),
(2, 1, 2, '2014-01-20'),
(3, 1, 5, '2014-01-20'),
(4, 1, 6, '2014-01-20');

-- --------------------------------------------------------

--
-- Structure de la table `eventtype`
--

CREATE TABLE IF NOT EXISTS `eventtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `eventtype`
--

INSERT INTO `eventtype` (`id`, `label`) VALUES
(1, 'Start'),
(2, 'End'),
(3, 'Sprint planning'),
(4, 'Daily meeting'),
(5, 'Sprint review'),
(6, 'Sprint retrospective');

-- --------------------------------------------------------

--
-- Structure de la table `participate`
--

CREATE TABLE IF NOT EXISTS `participate` (
  `idSprint` int(11) NOT NULL,
  `idCollaborator` int(11) NOT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`idSprint`,`idCollaborator`,`idRole`),
  KEY `fk_sprint_has_collaborator_collaborator1_idx` (`idCollaborator`),
  KEY `fk_sprint_has_collaborator_sprint1_idx` (`idSprint`),
  KEY `fk_sprint_has_collaborator_role1_idx` (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `playrole`
--

CREATE TABLE IF NOT EXISTS `playrole` (
  `idCollaborator` int(11) NOT NULL,
  `idRole` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  PRIMARY KEY (`idCollaborator`,`idRole`,`idProduct`),
  KEY `fk_product_has_collaborator_collaborator1_idx` (`idCollaborator`),
  KEY `fk_product_has_collaborator_product1_idx` (`idProduct`),
  KEY `fk_playRole_role1_idx` (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `playrole`
--

INSERT INTO `playrole` (`idCollaborator`, `idRole`, `idProduct`) VALUES
(1, 1, 3),
(1, 2, 3),
(2, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `product`
--

INSERT INTO `product` (`id`, `name`, `description`) VALUES
(1, 'BugReport', 'application web de remontée d''incidents'),
(2, 'ScrumTools', 'application de gestion de projets scrum'),
(3, 'Plan2Tests', 'application web de réalisation de plans de tests fonctionnels manuels');

-- --------------------------------------------------------

--
-- Structure de la table `realize`
--

CREATE TABLE IF NOT EXISTS `realize` (
  `idCollaborator` int(11) NOT NULL,
  `idUserStory` int(11) NOT NULL,
  PRIMARY KEY (`idCollaborator`,`idUserStory`),
  KEY `fk_Collaborator_has_userStory_userStory1_idx` (`idUserStory`),
  KEY `fk_Collaborator_has_userStory_Collaborator1_idx` (`idCollaborator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `realize`
--

INSERT INTO `realize` (`idCollaborator`, `idUserStory`) VALUES
(2, 7),
(2, 8);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Scrum master'),
(2, 'Product owner'),
(3, 'Collaborator');

-- --------------------------------------------------------

--
-- Structure de la table `sprint`
--

CREATE TABLE IF NOT EXISTS `sprint` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) DEFAULT NULL,
  `idProduct` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Sprint_Product1_idx` (`idProduct`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `sprint`
--

INSERT INTO `sprint` (`id`, `label`, `idProduct`) VALUES
(1, 'first', 3),
(2, 'second', 3),
(3, 'third', 3);

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `idStatus` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `status`
--

INSERT INTO `status` (`idStatus`, `label`) VALUES
(1, 'A faire'),
(2, 'En cours'),
(3, 'Fini');

-- --------------------------------------------------------

--
-- Structure de la table `userstory`
--

CREATE TABLE IF NOT EXISTS `userstory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  `description` longtext,
  `storyPoints` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `finishedAt` date DEFAULT NULL,
  `idStatus` int(11) NOT NULL,
  `idSprint` int(11) DEFAULT NULL,
  `idProduct` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userStory_status1_idx` (`idStatus`),
  KEY `fk_userStory_Sprint1_idx` (`idSprint`),
  KEY `fk_userStory_product1_idx` (`idProduct`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `userstory`
--

INSERT INTO `userstory` (`id`, `label`, `description`, `storyPoints`, `priority`, `finishedAt`, `idStatus`, `idSprint`, `idProduct`) VALUES
(1, 'Analyse fonctionnelle', 'analyse fonctionnelle du projet', 6, 5, NULL, 1, 1, 3),
(2, 'MCD - Analyse des données', 'structuration des données du projet', 4, 5, NULL, 1, 1, 3),
(3, 'Aut1 : se connecter', 'se connecter à l''application de manière sécurisée', 3, 8, NULL, 1, 1, 3),
(4, 'Tes4 : Consulter le détail d''un plan de tests', 'consulter le détail d''un plans de tests fonctionnels manuels', 4, 3, NULL, 1, NULL, 3),
(5, 'Tes5 : Renseigner une fonction après test', 'renseigner une fonction après test', 4, 13, NULL, 1, NULL, 3),
(6, 'Tes 6 : Consulter l''avancement d''un plan de test', 'consulter l''avancement d''un plan de test', 1, 13, NULL, 1, NULL, 3),
(7, 'Tes2 : Page d''accueil (testeur)', 'page d''accueil du testeur', 20, 140, NULL, 1, NULL, 3),
(8, 'Tes1 : faire une demande d''inscription', 'faire une demande d''inscription à un test', 4, 30, NULL, 1, NULL, 3);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `fk_Comment_Collaborator1` FOREIGN KEY (`idCollaborator`) REFERENCES `collaborator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Comment_CommentType1` FOREIGN KEY (`idCommentType`) REFERENCES `commenttype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Comment_userStory1` FOREIGN KEY (`idUserStory`) REFERENCES `userstory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `fk_event_eventType1` FOREIGN KEY (`idEventType`) REFERENCES `eventtype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_event_Sprint` FOREIGN KEY (`idSprint`) REFERENCES `sprint` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `participate`
--
ALTER TABLE `participate`
  ADD CONSTRAINT `fk_sprint_has_collaborator_collaborator1` FOREIGN KEY (`idCollaborator`) REFERENCES `collaborator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sprint_has_collaborator_role1` FOREIGN KEY (`idRole`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sprint_has_collaborator_sprint1` FOREIGN KEY (`idSprint`) REFERENCES `sprint` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `playrole`
--
ALTER TABLE `playrole`
  ADD CONSTRAINT `fk_playRole_role1` FOREIGN KEY (`idRole`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_product_has_collaborator_collaborator1` FOREIGN KEY (`idCollaborator`) REFERENCES `collaborator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_product_has_collaborator_product1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `realize`
--
ALTER TABLE `realize`
  ADD CONSTRAINT `fk_Collaborator_has_userStory_Collaborator1` FOREIGN KEY (`idCollaborator`) REFERENCES `collaborator` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Collaborator_has_userStory_userStory1` FOREIGN KEY (`idUserStory`) REFERENCES `userstory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sprint`
--
ALTER TABLE `sprint`
  ADD CONSTRAINT `fk_Sprint_Product1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `userstory`
--
ALTER TABLE `userstory`
  ADD CONSTRAINT `fk_userStory_product1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_userStory_Sprint1` FOREIGN KEY (`idSprint`) REFERENCES `sprint` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_userStory_status1` FOREIGN KEY (`idStatus`) REFERENCES `status` (`idStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

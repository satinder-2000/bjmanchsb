-- bjm.Access definition

CREATE TABLE `Access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profileFile` varchar(100) DEFAULT NULL,
  `image` mediumblob NOT NULL,
  `failedAttempts` tinyint(4) NOT NULL DEFAULT 0,
  `createdOn` datetime NOT NULL,
  `updatedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.Activity definition

CREATE TABLE `Activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activityId` int(11) NOT NULL,
  `activityType` char(25) NOT NULL,
  `createdOn` datetime NOT NULL,
  `description` varchar(150) NOT NULL,
  `ownerEmail` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.Blog definition

CREATE TABLE `Blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publishedByAccessId` int(11) NOT NULL,
  `publishedByEmail` varchar(100) NOT NULL,
  `publishedOn` datetime NOT NULL,
  `summary` varchar(500) NOT NULL,
  `text` longtext NOT NULL,
  `title` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.BlogAbuse definition

CREATE TABLE `BlogAbuse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogCommentId` int(11) NOT NULL,
  `reportedText` varchar(500) NOT NULL,
  `reportedByAccessId` int(11) NOT NULL,
  `reportedByEmail` varchar(100) NOT NULL,
  `reportedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.BlogComment definition

CREATE TABLE `BlogComment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogCommenterAccessId` int(11) NOT NULL,
  `blogCommenterEmail` varchar(100) NOT NULL,
  `blogId` int(11) NOT NULL,
  `comment` varchar(750) NOT NULL,
  `dated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.Forum definition

CREATE TABLE `Forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forumCreatorEmail` varchar(100) NOT NULL,
  `categoryType` varchar(100) NOT NULL,
  `categorySubType` varchar(100) NOT NULL,
  `title` varchar(150) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `createdOn` datetime NOT NULL,
  `updatedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.ForumAbuse definition

CREATE TABLE `ForumAbuse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forumCommentId` int(11) NOT NULL,
  `reportedByAccessId` int(11) NOT NULL,
  `reportedByEmail` varchar(100) NOT NULL,
  `reportText` varchar(1000) NOT NULL,
  `reportedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.ForumCategory definition

CREATE TABLE `ForumCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `subType` varchar(100) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.ForumComment definition

CREATE TABLE `ForumComment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) NOT NULL,
  `dated` datetime NOT NULL,
  `forumCommenterAccessId` int(11) NOT NULL,
  `forumCommenterEmail` varchar(100) NOT NULL,
  `forumId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.LokSabha definition

CREATE TABLE `LokSabha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stateCode` varchar(2) NOT NULL,
  `constituency` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=545 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.LokSabhaNominate definition

CREATE TABLE `LokSabhaNominate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `constituency` varchar(100) NOT NULL,
  `candidateName` varchar(100) NOT NULL,
  `nominatedByAccessId` int(11) NOT NULL,
  `nominatedByEmail` varchar(100) NOT NULL,
  `nominatedOn` datetime NOT NULL,
  `nominationCount` int(11) NOT NULL,
  `stateCode` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.State definition

CREATE TABLE `State` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `name` varchar(100) NOT NULL,
  `postCodePrefix` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.Survey definition

CREATE TABLE `Survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surveyCreatorEmail` varchar(100) NOT NULL,
  `categoryType` varchar(100) NOT NULL,
  `categorySubType` varchar(100) NOT NULL,
  `title` varchar(125) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `createdOn` datetime NOT NULL,
  `updatedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyAbuse definition

CREATE TABLE `SurveyAbuse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reportText` varchar(1000) NOT NULL,
  `reportedByAccessId` int(11) NOT NULL,
  `reportedByEmail` varchar(100) NOT NULL,
  `reportedOn` datetime NOT NULL,
  `surveyVoteId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyCategory definition

CREATE TABLE `SurveyCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `subType` varchar(100) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyFromForum definition

CREATE TABLE `SurveyFromForum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surveyCreatorEmail` varchar(100) NOT NULL,
  `categoryType` varchar(100) NOT NULL,
  `categorySubType` varchar(100) NOT NULL,
  `title` varchar(125) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `createdOn` datetime NOT NULL,
  `updatedOn` datetime NOT NULL,
  `forumId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyFromForumAbuse definition

CREATE TABLE `SurveyFromForumAbuse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reportText` varchar(1000) NOT NULL,
  `reportByAccessId` int(11) NOT NULL,
  `reportByEmail` varchar(100) NOT NULL,
  `reportedOn` datetime NOT NULL,
  `surveyFromForumVoteId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyFromForumVote definition

CREATE TABLE `SurveyFromForumVote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) NOT NULL,
  `dated` datetime NOT NULL,
  `surveyFromForumId` int(11) NOT NULL,
  `voteType` varchar(9) NOT NULL,
  `voterAccessId` int(11) NOT NULL,
  `voterEmail` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.SurveyVote definition

CREATE TABLE `SurveyVote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(1000) NOT NULL,
  `dated` datetime NOT NULL,
  `voteType` varchar(9) NOT NULL,
  `surveyId` int(11) NOT NULL,
  `voterAccessId` int(11) NOT NULL,
  `voterEmail` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.`User` definition

CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `dob` char(10) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `stateCode` varchar(2) NOT NULL,
  `stateName` varchar(100) NOT NULL,
  `lokSabhaConstituency` varchar(100) NOT NULL,
  `vidhanSabhaConstituency` varchar(100) DEFAULT NULL,
  `createdOn` datetime NOT NULL,
  `updatedOn` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.VidhanSabha definition

CREATE TABLE `VidhanSabha` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stateCode` varchar(2) NOT NULL,
  `constituency` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3877 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- bjm.VidhanSabhaNominate definition

CREATE TABLE `VidhanSabhaNominate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `candidateName` varchar(100) NOT NULL,
  `constituency` varchar(100) NOT NULL,
  `nominatedByAccessId` int(11) NOT NULL,
  `nominatedByEmail` varchar(100) DEFAULT NULL,
  `nominatedOn` datetime NOT NULL,
  `nominationCount` int(11) NOT NULL,
  `stateCode` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
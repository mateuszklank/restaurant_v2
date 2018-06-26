-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               8.0.11 - MySQL Community Server - GPL
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Zrzut struktury bazy danych restaurant
CREATE DATABASE IF NOT EXISTS `restaurant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `restaurant`;

-- Zrzut struktury tabela restaurant.list
CREATE TABLE IF NOT EXISTS `list` (
  `id_order` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  KEY `FK_list_order` (`id_order`),
  KEY `FK_list_products` (`id_product`),
  CONSTRAINT `FK_list_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  CONSTRAINT `FK_list_products` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabela z listą produktów poszczególnego zamówienia.';

-- Zrzucanie danych dla tabeli restaurant.list: ~2 rows (około)
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
INSERT INTO `list` (`id_order`, `id_product`) VALUES
	(1, 2),
	(1, 1);
/*!40000 ALTER TABLE `list` ENABLE KEYS */;

-- Zrzut struktury tabela restaurant.order
CREATE TABLE IF NOT EXISTS `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `order_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `street` varchar(50) NOT NULL DEFAULT '0',
  `house` varchar(50) NOT NULL DEFAULT '0',
  `code` varchar(50) NOT NULL DEFAULT '0',
  `id_user` int(11) DEFAULT '0',
  PRIMARY KEY (`id_order`),
  KEY `FK_order_user` (`id_user`),
  CONSTRAINT `FK_order_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabela przechowuje informacje związane z zamówieniem złożonym w restauracji.';

-- Zrzucanie danych dla tabeli restaurant.order: ~1 rows (około)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id_order`, `order_price`, `city`, `street`, `house`, `code`, `id_user`) VALUES
	(1, 27.48, 'Kielce', 'Słoneczna', '9a/12', '25-728', 2);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- Zrzut struktury tabela restaurant.products
CREATE TABLE IF NOT EXISTS `products` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  `count` int(11) NOT NULL,
  `vege` bit(1) NOT NULL,
  `gluten` bit(1) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabela przechowuje wszystkie dane pojedynczego produktu dostępnego w restauracji.';

-- Zrzucanie danych dla tabeli restaurant.products: ~2 rows (około)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id_product`, `name`, `unit_price`, `count`, `vege`, `gluten`, `description`, `category`) VALUES
	(1, 'Tortilla z kurczakiem', 14.99, 40, b'0', b'0', 'Tortilla z kurczakiem, papryką, pomidorem, serem, cebulą, sałatą i sosem jogurtowym', 'Obiad'),
	(2, 'Falafel Burger', 12.49, 30, b'1', b'0', 'Bułka pszenna z falafelami, sałatą, pomidorem, wege serem, cebulką i naszym wege majonezem', 'Obiad');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

-- Zrzut struktury tabela restaurant.user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '0',
  `lastname` varchar(50) NOT NULL DEFAULT '0',
  `phone` varchar(50) NOT NULL DEFAULT '0',
  `role` varchar(50) NOT NULL DEFAULT '0',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `street` varchar(50) NOT NULL DEFAULT '0',
  `house` varchar(50) NOT NULL DEFAULT '0',
  `code` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabela do przechowywania danych pracowników restauracji.';

-- Zrzucanie danych dla tabeli restaurant.user: ~2 rows (około)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `firstname`, `lastname`, `phone`, `role`, `city`, `street`, `house`, `code`) VALUES
	(1, 'Mateusz', 'Klank', '543-543-678', 'Administrator', 'Kielce', 'Urzędnicza', '7a/70', '25-729'),
	(2, 'Andrzej', 'Kowalski', '786-345-369', 'Kelner', 'Kielce', 'Żelazna', '4/91', '25-732');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

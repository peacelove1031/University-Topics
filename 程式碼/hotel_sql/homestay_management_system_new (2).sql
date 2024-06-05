-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主機： 127.0.0.1
-- 產生時間： 2022-09-06 00:37:31
-- 伺服器版本： 10.4.19-MariaDB
-- PHP 版本： 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `homestay_management_system_new`
--

-- --------------------------------------------------------

--
-- 資料表結構 `table_booking`
--

CREATE TABLE `table_booking` (
  `id` int(11) NOT NULL,
  `hotel_id` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT '',
  `time` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_booking`
--

INSERT INTO `table_booking` (`id`, `hotel_id`, `user_id`, `status`, `time`) VALUES
(1, '有料旅館', 's2410831021', 'status_0_6', '2022-01-16 22:21:37.000000'),
(2, '確實旅館', 's2410831010', 'status_0_6', '2022-02-15 22:21:57.000000'),
(3, '實在旅館', 's2410831031', 'status_0_6', '2022-05-16 22:22:29.000000'),
(4, '老實旅館', 's2410831040', 'status_0_6', '2022-07-16 22:22:29.000000'),
(5, '冷靜旅館', 's2410831003', 'status_0_6', '2022-08-16 22:22:40.000000');

-- --------------------------------------------------------

--
-- 資料表結構 `table_edidmic`
--

CREATE TABLE `table_edidmic` (
  `id` int(11) NOT NULL,
  `member_id` varchar(30) NOT NULL,
  `hotel_id` varchar(30) NOT NULL,
  `member_temp` float NOT NULL,
  `temp_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_edidmic`
--

INSERT INTO `table_edidmic` (`id`, `member_id`, `hotel_id`, `member_temp`, `temp_time`) VALUES
(1, 's2410831021', 'h001', 36.1, '2022-08-01 15:30:16'),
(2, 's2410831010', 'h002', 36.2, '2022-08-01 15:30:16'),
(3, 's2410831031', 'h003', 36.3, '2022-08-01 15:31:49'),
(4, 's2410831040', 'h004', 36.4, '2022-08-01 15:31:49'),
(5, 's2410831003', 'h005', 36.5, '2022-08-01 15:32:20'),
(6, 's2410831021', 'h006', 36.1, '2022-08-02 15:13:54'),
(7, 's2410831010', 'h007', 36.2, '2022-08-02 15:13:54'),
(8, 's2410831031', 'h008', 36.3, '2022-08-02 15:13:54'),
(9, 's2410831040', 'h009', 36.4, '2022-08-02 15:13:54'),
(10, 's2410831003', 'h010', 36.5, '2022-08-02 15:13:54');

-- --------------------------------------------------------

--
-- 資料表結構 `table_hotel`
--

CREATE TABLE `table_hotel` (
  `id` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `person` varchar(50) NOT NULL,
  `dollar` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_hotel`
--

INSERT INTO `table_hotel` (`id`, `city`, `name`, `person`, `dollar`, `status`, `time`) VALUES
(1, '台中市', '有料旅館', '1', '2000', 'status_0_3', '2022-08-16 22:22:57'),
(2, '台北市', '確實旅館', '2', '6000', 'status_0_3', '2022-08-16 22:23:03'),
(3, '高雄', '實在旅館', '3', '5000', 'status_0_3', '2022-08-16 22:23:08'),
(4, '台南', '老實旅館', '4', '10000', 'status_0_3', '2022-08-16 22:23:13'),
(5, '台東', '奧利給旅館', '6', '15000', 'status_0_3', '2022-08-16 22:23:18');

-- --------------------------------------------------------

--
-- 資料表結構 `table_hotel_rank`
--

CREATE TABLE `table_hotel_rank` (
  `id` int(11) NOT NULL,
  `hotel_id` varchar(50) NOT NULL,
  `star` varchar(50) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_hotel_rank`
--

INSERT INTO `table_hotel_rank` (`id`, `hotel_id`, `star`, `time`) VALUES
(1, '有料旅館', '5', '2022-08-16 22:23:28'),
(2, '確實旅館', '4.8', '2022-08-16 22:23:42'),
(3, '實在旅館', '4.7', '2022-08-16 22:23:53'),
(4, '老實旅館', '4.6', '2022-08-16 22:24:03'),
(5, '冷靜旅館', '4.5', '2022-08-16 22:24:10'),
(6, '奧利給旅館', '4.4', '2022-08-16 22:26:04'),
(7, '柬普寨旅館', '4.3', '2022-08-16 22:24:23'),
(8, '越南旅館', '4.2', '2022-08-16 22:24:31'),
(9, '泰國旅館', '4.1', '2022-08-16 22:24:39'),
(10, '印度旅館', '4', '2022-08-16 22:24:47');

-- --------------------------------------------------------

--
-- 資料表結構 `table_member`
--

CREATE TABLE `table_member` (
  `id` int(11) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 資料表結構 `table_room`
--

CREATE TABLE `table_room` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 資料表結構 `table_room_log`
--

CREATE TABLE `table_room_log` (
  `id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 資料表結構 `table_status`
--

CREATE TABLE `table_status` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hotel_id` varchar(50) DEFAULT '',
  `room_id` varchar(50) DEFAULT '',
  `time` varchar(50) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 資料表結構 `table_type`
--

CREATE TABLE `table_type` (
  `id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `key` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_type`
--

INSERT INTO `table_type` (`id`, `type`, `name`, `key`) VALUES
(1, 'clear', '清潔服務', 'clear_0'),
(2, 'food', '送餐服務', 'food_0'),
(3, 'callout', '來訪服務', 'callout_0'),
(4, 'bus', '接送服務', 'bus_0'),
(5, 'temp', '體溫測量', 'temp_0'),
(6, 'room', '訂房服務', 'room_0'),
(7, 'door', '門前侍衛', 'door_0'),
(8, 'roomdoor', '房務事衛', 'roomdoor_0'),
(9, 'gamedoor', '娛樂侍衛', 'gamedoor_0'),
(10, 'joinus', '加入我們', 'joinus_0'),
(11, 'contact', '聯絡我們', 'contact_0'),
(12, 'food_0', '火雞肉飯', 'food_0_1'),
(13, 'food_0', '叉燒飯', 'food_0_2'),
(14, 'food_0', '雞排飯', 'food_0_3'),
(15, 'food_0', '排骨飯', 'food_0_4'),
(16, 'food_0', '魯雞飯', 'food_0_5'),
(17, 'clear_0', '清理垃圾', 'clear_0_1'),
(18, 'clear_0', '拖地', 'clear_0_2'),
(19, 'clear_0', '掃地', 'clear_0_3'),
(20, 'clear_0', '擦拭家俱', 'clear_0_4'),
(21, 'clear_0', '更換床單', 'clear_0_5'),
(22, 'bus_0', '計程車', 'bus_0_1'),
(23, 'temp_0', '體溫測量', 'temp_0_1'),
(24, 'callout_0', '進出時間', 'callout_0_1'),
(25, 'room_0', '預訂房間', 'room_0_1'),
(26, 'door_0', '大門門禁', 'door_0_1'),
(27, 'roomdoor_0', '房間門禁', 'roomdoor_0_1'),
(28, 'gamedoor_0', '撞球間', 'gamedoor_0_1'),
(29, 'gamedoor_0', '游泳池', 'gamedoor_0_2'),
(30, 'gamedoor_0', '唱歌間', 'gamedoor_0_3'),
(31, 'joinus_0', '有料股份有限公司', 'joinus_0_1'),
(32, 'joinus_0', '確實股份有限公司', 'joinus_0_2'),
(33, 'contact_0', '畫面閃退', 'contact_0_1'),
(34, 'contact_0', '服務沒抵達', 'contact_0_2'),
(35, 'food_0', '珍珠奶茶', 'food_0_6'),
(36, 'food_0', '奶茶', 'food_0_7'),
(37, 'food_0', '紅茶', 'food_0_8'),
(38, 'food_0', '綠茶', 'food_0_9'),
(39, 'food_0', '青茶', 'food_0_10'),
(40, 'food_0', '炸物拼盤', 'food_0_11'),
(41, 'food_0', '水餃', 'food_0_12'),
(42, 'food_0', '雞塊', 'food_0_13'),
(43, 'food_0', '薯條', 'food_0_14'),
(44, 'food_0', '甜不辣', 'food_0_15'),
(45, 'food_0', '黑胡椒麵加蛋', 'food_0_16'),
(46, 'food_0', '薯餅', 'food_0_17'),
(47, 'food_0', '花生厚片土司', 'food_0_18'),
(48, 'food_0', '雞排', 'food_0_19'),
(49, 'food_0', '維力炸醬麵', 'food_0_20'),
(50, 'food_0', '滿漢大餐', 'food_0_21'),
(51, 'status', '狀態', 'status_0'),
(52, 'status_0', '異常', 'status_0_0'),
(53, 'status_0', '正常', 'status_0_1'),
(54, 'status_0', '未紀錄', 'status_0_2'),
(55, 'status_0', '空房', 'status_0_3'),
(56, 'status_0', '等待入住', 'status_0_4'),
(57, 'status_0', '入住', 'status_0_5'),
(58, 'status_0', '退房', 'status_0_6');

-- --------------------------------------------------------

--
-- 資料表結構 `table_user`
--

CREATE TABLE `table_user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_user`
--

INSERT INTO `table_user` (`id`, `name`, `account`, `password`, `address`, `tel`) VALUES
(1, '林小漢', 's2410831021', '123456', '台中市大里區', '0912-345-678'),
(2, '郭小安', 's2410831010', '654321', '台中市太平區', '0998-765-432'),
(3, '劉小毅', 's2410831031', '13579', '台中市后里區', '0987-654-321'),
(4, '林小勳', 's2410831040', '246810', '台中市烏日區', '0963-852-741'),
(5, '黃小榮', 's2410831003', '132456', '嘉義市郊區', '0974-852-963');

-- --------------------------------------------------------

--
-- 資料表結構 `table_user_service`
--

CREATE TABLE `table_user_service` (
  `id` int(11) NOT NULL,
  `type_key` varchar(50) NOT NULL,
  `user_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 傾印資料表的資料 `table_user_service`
--

INSERT INTO `table_user_service` (`id`, `type_key`, `user_id`, `room_id`, `time`) VALUES
(1, 'clear_0_1', 1, 1, '2022-08-12 16:41:14'),
(6, 'clear_0_1', 1, 1, '2022-08-13 13:54:35'),
(7, 'clear_0_1', 1, 1, '2022-08-13 15:02:04'),
(8, 'food_0_2', 1, 1, '2022-08-13 15:03:01'),
(9, 'bus_0_1', 1, 1, '2022-08-13 15:30:05'),
(10, 'clear_0_2', 1, 1, '2022-08-13 15:33:57'),
(11, 'clear_0_5', 1, 1, '2022-08-14 12:04:22'),
(12, 'clear_0_2', 1, 1, '2022-08-14 12:09:44'),
(13, 'food_0_1', 1, 1, '2022-08-14 12:10:13'),
(14, 'clear_0_2', 1, 1, '2022-08-26 23:47:57'),
(15, 'clear_0_1', 1, 1, '2022-09-03 22:42:33'),
(16, 'clear_0_1', 1, 1, '2022-09-03 22:42:33');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `table_booking`
--
ALTER TABLE `table_booking`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_edidmic`
--
ALTER TABLE `table_edidmic`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_hotel`
--
ALTER TABLE `table_hotel`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_hotel_rank`
--
ALTER TABLE `table_hotel_rank`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_member`
--
ALTER TABLE `table_member`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_room`
--
ALTER TABLE `table_room`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_room_log`
--
ALTER TABLE `table_room_log`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_status`
--
ALTER TABLE `table_status`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_type`
--
ALTER TABLE `table_type`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_user`
--
ALTER TABLE `table_user`
  ADD PRIMARY KEY (`id`);

--
-- 資料表索引 `table_user_service`
--
ALTER TABLE `table_user_service`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_booking`
--
ALTER TABLE `table_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_edidmic`
--
ALTER TABLE `table_edidmic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_hotel`
--
ALTER TABLE `table_hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_hotel_rank`
--
ALTER TABLE `table_hotel_rank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_member`
--
ALTER TABLE `table_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_room`
--
ALTER TABLE `table_room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_room_log`
--
ALTER TABLE `table_room_log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_status`
--
ALTER TABLE `table_status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_type`
--
ALTER TABLE `table_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_user`
--
ALTER TABLE `table_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `table_user_service`
--
ALTER TABLE `table_user_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

package com.sgcy.shadow.home.bean;

import java.util.List;

/**
 * Created by sg on 2018/6/3.
 *
 * 正在售票
 */
public class SellTicketBean {

    /**
     * count : 15
     * movies : [{"actorName1":"赵又廷","actorName2":"杨子姗","btnText":"","commonSpecial":"赵又廷杨子姗南极绝境相拥取暖","directorName":"吴有音","img":"http://img5.mtime.cn/mt/2018/01/03/093915.15928228_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":114,"movieId":223804,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":142,"nearestShowDay":1517644800,"nearestShowtimeCount":595},"preferentialFlag":false,"rDay":2,"rMonth":2,"rYear":2018,"ratingFinal":7.1,"titleCn":"南极之恋","titleEn":"Till The End Of The World","type":"爱情 / 冒险","wantedCount":549},{"actorName1":"休·杰克曼","actorName2":"米歇尔·威廉姆斯","btnText":"","commonSpecial":"休叔领衔顶级歌舞表演秀","directorName":"迈克尔·格雷西","img":"http://img5.mtime.cn/mt/2018/02/01/105051.50396901_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":true,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":105,"movieId":149326,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":137,"nearestShowDay":1517644800,"nearestShowtimeCount":652},"preferentialFlag":false,"rDay":1,"rMonth":2,"rYear":2018,"ratingFinal":7.9,"titleCn":"马戏之王","titleEn":"The Greatest Showman","type":"传记 / 剧情 / 歌舞","wantedCount":1101},{"actorName1":"山田凉介","actorName2":"西田敏行","btnText":"","commonSpecial":"山田凉介讲述治愈系温情故事","directorName":"广木隆一","img":"http://img5.mtime.cn/mt/2018/01/29/095529.60129074_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":129,"movieId":238508,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":123,"nearestShowDay":1517644800,"nearestShowtimeCount":371},"preferentialFlag":false,"rDay":2,"rMonth":2,"rYear":2018,"ratingFinal":7,"titleCn":"浪矢解忧杂货店","titleEn":"Namiya Zakka Ten No Kiseki","type":"剧情","wantedCount":386},{"actorName1":"阿米尔·汗","actorName2":"塞伊拉·沃西","btnText":"","commonSpecial":"印度少女追梦路上困难重重","directorName":"阿瓦提·钱德安","img":"http://img5.mtime.cn/mt/2017/12/28/100211.43599999_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":true,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":150,"movieId":249736,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":144,"nearestShowDay":1517644800,"nearestShowtimeCount":703},"preferentialFlag":false,"rDay":19,"rMonth":1,"rYear":2018,"ratingFinal":8,"titleCn":"神秘巨星","titleEn":"Secret Superstar","type":"剧情 / 喜剧 / 音乐","wantedCount":1162},{"actorName1":"章子怡","actorName2":"张震","btnText":"","commonSpecial":"章子怡黄晓明为爱牺牲","directorName":"李芳芳","img":"http://img5.mtime.cn/mt/2018/01/11/100517.55455726_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":138,"movieId":154373,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":135,"nearestShowDay":1517644800,"nearestShowtimeCount":540},"preferentialFlag":false,"rDay":12,"rMonth":1,"rYear":2018,"ratingFinal":7,"titleCn":"无问西东","titleEn":"Forever Young","type":"剧情 / 爱情 / 战争","wantedCount":5077},{"actorName1":"梁朝伟","actorName2":"白百何","btnText":"","commonSpecial":"","directorName":"许诚毅","img":"http://img5.mtime.cn/mt/2018/01/05/175658.82351501_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":110,"movieId":237182,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":105,"nearestShowDay":1518768000,"nearestShowtimeCount":815},"preferentialFlag":false,"rDay":16,"rMonth":2,"rYear":2018,"ratingFinal":-1,"titleCn":"捉妖记2","titleEn":"Monster Hunt 2","type":"喜剧 / 奇幻 / 动作","wantedCount":3544},{"actorName1":"迪伦·奥布莱恩","actorName2":"卡雅·斯考达里奥","btnText":"","commonSpecial":"\"跑男团\"探寻迷宫共赴龙潭虎穴","directorName":"韦斯·波尔","img":"http://img5.mtime.cn/mt/2017/12/25/100606.71445552_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":142,"movieId":223926,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":120,"nearestShowDay":1517644800,"nearestShowtimeCount":411},"preferentialFlag":false,"rDay":26,"rMonth":1,"rYear":2018,"ratingFinal":6.2,"titleCn":"移动迷宫3：死亡解药","titleEn":"Maze Runner: The Death Cure","type":"动作 / 科幻 / 惊悚","wantedCount":2983},{"actorName1":"奥卓·阿杜巴","actorName2":"艾米莉·布朗特","btnText":"","commonSpecial":"六只可爱小马的神奇冒险之旅","directorName":"杰森·西森","img":"http://img5.mtime.cn/mt/2018/02/02/114639.16922848_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":100,"movieId":217852,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":111,"nearestShowDay":1517644800,"nearestShowtimeCount":331},"preferentialFlag":false,"rDay":2,"rMonth":2,"rYear":2018,"ratingFinal":7.2,"titleCn":"小马宝莉大电影","titleEn":"My Little Pony: The Movie","type":"动画 / 冒险 / 喜剧","wantedCount":295},{"actorName1":"郭富城","actorName2":"冯绍峰","btnText":"","commonSpecial":"","directorName":"郑保瑞","img":"http://img5.mtime.cn/mt/2018/01/23/094118.33045114_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":116,"movieId":209205,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":87,"nearestShowDay":1518595200,"nearestShowtimeCount":414},"preferentialFlag":false,"rDay":16,"rMonth":2,"rYear":2018,"ratingFinal":-1,"titleCn":"西游记女儿国","titleEn":"The Monkey King 3","type":"喜剧 / 爱情 / 动作","wantedCount":2258},{"actorName1":"","actorName2":"","btnText":"","commonSpecial":"","directorName":"丁亮","img":"http://img5.mtime.cn/mt/2018/02/01/101421.62196189_1280X720X2.jpg","is3D":true,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":90,"movieId":251605,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":108,"nearestShowDay":1517644800,"nearestShowtimeCount":346},"preferentialFlag":false,"rDay":16,"rMonth":2,"rYear":2018,"ratingFinal":-1,"titleCn":"熊出没·变形记","titleEn":"Boonie Bears : The Big Shrink","type":"动画 / 喜剧 / 冒险","wantedCount":488},{"actorName1":"王宝强","actorName2":"刘昊然","btnText":"","commonSpecial":"","directorName":"陈思诚","img":"http://img5.mtime.cn/mt/2018/02/02/104001.97804444_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":true,"isIMAX3D":false,"isNew":false,"length":120,"movieId":234873,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":102,"nearestShowDay":1518768000,"nearestShowtimeCount":677},"preferentialFlag":false,"rDay":16,"rMonth":2,"rYear":2018,"ratingFinal":-1,"titleCn":"唐人街探案2","titleEn":"Detective Chinatown 2","type":"喜剧 / 动作 / 悬疑","wantedCount":3472},{"actorName1":"朱莉娅·罗伯茨","actorName2":"欧文·威尔逊","btnText":"","commonSpecial":"\"房间\"小正太毁容秀演技励志催泪","directorName":"斯蒂芬·卓博斯基","img":"http://img5.mtime.cn/mt/2018/01/10/110932.42903292_1280X720X2.jpg","is3D":false,"isDMAX":false,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":113,"movieId":235349,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":97,"nearestShowDay":1517644800,"nearestShowtimeCount":301},"preferentialFlag":false,"rDay":19,"rMonth":1,"rYear":2018,"ratingFinal":8.2,"titleCn":"奇迹男孩","titleEn":"Wonder","type":"剧情 / 家庭","wantedCount":1648},{"actorName1":"杰西卡·罗德","actorName2":"伊瑟尔·布罗萨德","btnText":"","commonSpecial":"\"生死循环\"玩出新花样","directorName":"克里斯托弗·兰敦","img":"http://img5.mtime.cn/mt/2018/01/08/104524.96607652_1280X720X2.jpg","is3D":false,"isDMAX":true,"isFilter":true,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":96,"movieId":247403,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":97,"nearestShowDay":1517644800,"nearestShowtimeCount":287},"preferentialFlag":false,"rDay":2,"rMonth":2,"rYear":2018,"ratingFinal":7,"titleCn":"忌日快乐","titleEn":"Happy Death Day","type":"恐怖 / 悬疑 / 惊悚","wantedCount":540},{"actorName1":"约翰·塞纳","actorName2":"凯特·迈克金农","btnText":"","commonSpecial":"最萌大公牛开启冒险旅程","directorName":"卡洛斯·沙尔丹哈","img":"http://img5.mtime.cn/mt/2018/01/12/164908.52433662_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":false,"isNew":false,"length":106,"movieId":235816,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":69,"nearestShowDay":1517644800,"nearestShowtimeCount":143},"preferentialFlag":false,"rDay":19,"rMonth":1,"rYear":2018,"ratingFinal":7.5,"titleCn":"公牛历险记","titleEn":"Ferdinand","type":"动画 / 冒险 / 喜剧","wantedCount":1448},{"actorName1":"张译","actorName2":"黄景瑜","btnText":"","commonSpecial":"","directorName":"林超贤","img":"http://img5.mtime.cn/mt/2018/01/23/101144.79795555_1280X720X2.jpg","is3D":true,"isDMAX":true,"isFilter":false,"isHot":false,"isIMAX":false,"isIMAX3D":true,"isNew":false,"length":138,"movieId":240425,"nearestShowtime":{"isTicket":true,"nearestCinemaCount":91,"nearestShowDay":1518768000,"nearestShowtimeCount":350},"preferentialFlag":false,"rDay":16,"rMonth":2,"rYear":2018,"ratingFinal":-1,"titleCn":"红海行动","titleEn":"Operation Red Sea","type":"动作 / 剧情","wantedCount":1462}]
     * totalCinemaCount : 206
     * totalComingMovie : 35
     * totalHotMovie : 52
     */

    private int count;
    private int totalCinemaCount;
    private int totalComingMovie;
    private int totalHotMovie;
    private List<MoviesBean> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCinemaCount() {
        return totalCinemaCount;
    }

    public void setTotalCinemaCount(int totalCinemaCount) {
        this.totalCinemaCount = totalCinemaCount;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public int getTotalHotMovie() {
        return totalHotMovie;
    }

    public void setTotalHotMovie(int totalHotMovie) {
        this.totalHotMovie = totalHotMovie;
    }

    public List<MoviesBean> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesBean> movies) {
        this.movies = movies;
    }

    public static class MoviesBean {
        /**
         * actorName1 : 赵又廷
         * actorName2 : 杨子姗
         * btnText :
         * commonSpecial : 赵又廷杨子姗南极绝境相拥取暖
         * directorName : 吴有音
         * img : http://img5.mtime.cn/mt/2018/01/03/093915.15928228_1280X720X2.jpg
         * is3D : true
         * isDMAX : true
         * isFilter : false
         * isHot : true
         * isIMAX : false
         * isIMAX3D : false
         * isNew : false
         * length : 114
         * movieId : 223804
         * nearestShowtime : {"isTicket":true,"nearestCinemaCount":142,"nearestShowDay":1517644800,"nearestShowtimeCount":595}
         * preferentialFlag : false
         * rDay : 2
         * rMonth : 2
         * rYear : 2018
         * ratingFinal : 7.1
         * titleCn : 南极之恋
         * titleEn : Till The End Of The World
         * type : 爱情 / 冒险
         * wantedCount : 549
         */

        private String actorName1;
        private String actorName2;
        private String btnText;
        private String commonSpecial;
        private String directorName;
        private String img;
        private boolean is3D;
        private boolean isDMAX;
        private boolean isFilter;
        private boolean isHot;
        private boolean isIMAX;
        private boolean isIMAX3D;
        private boolean isNew;
        private int length;
        private int movieId;
        private NearestShowtimeBean nearestShowtime;
        private boolean preferentialFlag;
        private int rDay;
        private int rMonth;
        private int rYear;
        private double ratingFinal;
        private String titleCn;
        private String titleEn;
        private String type;
        private int wantedCount;

        public String getActorName1() {
            return actorName1;
        }

        public void setActorName1(String actorName1) {
            this.actorName1 = actorName1;
        }

        public String getActorName2() {
            return actorName2;
        }

        public void setActorName2(String actorName2) {
            this.actorName2 = actorName2;
        }

        public String getBtnText() {
            return btnText;
        }

        public void setBtnText(String btnText) {
            this.btnText = btnText;
        }

        public String getCommonSpecial() {
            return commonSpecial;
        }

        public void setCommonSpecial(String commonSpecial) {
            this.commonSpecial = commonSpecial;
        }

        public String getDirectorName() {
            return directorName;
        }

        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public boolean isIs3D() {
            return is3D;
        }

        public void setIs3D(boolean is3D) {
            this.is3D = is3D;
        }

        public boolean isIsDMAX() {
            return isDMAX;
        }

        public void setIsDMAX(boolean isDMAX) {
            this.isDMAX = isDMAX;
        }

        public boolean isIsFilter() {
            return isFilter;
        }

        public void setIsFilter(boolean isFilter) {
            this.isFilter = isFilter;
        }

        public boolean isIsHot() {
            return isHot;
        }

        public void setIsHot(boolean isHot) {
            this.isHot = isHot;
        }

        public boolean isIsIMAX() {
            return isIMAX;
        }

        public void setIsIMAX(boolean isIMAX) {
            this.isIMAX = isIMAX;
        }

        public boolean isIsIMAX3D() {
            return isIMAX3D;
        }

        public void setIsIMAX3D(boolean isIMAX3D) {
            this.isIMAX3D = isIMAX3D;
        }

        public boolean isIsNew() {
            return isNew;
        }

        public void setIsNew(boolean isNew) {
            this.isNew = isNew;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public NearestShowtimeBean getNearestShowtime() {
            return nearestShowtime;
        }

        public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
            this.nearestShowtime = nearestShowtime;
        }

        public boolean isPreferentialFlag() {
            return preferentialFlag;
        }

        public void setPreferentialFlag(boolean preferentialFlag) {
            this.preferentialFlag = preferentialFlag;
        }

        public int getRDay() {
            return rDay;
        }

        public void setRDay(int rDay) {
            this.rDay = rDay;
        }

        public int getRMonth() {
            return rMonth;
        }

        public void setRMonth(int rMonth) {
            this.rMonth = rMonth;
        }

        public int getRYear() {
            return rYear;
        }

        public void setRYear(int rYear) {
            this.rYear = rYear;
        }

        public double getRatingFinal() {
            return ratingFinal;
        }

        public void setRatingFinal(double ratingFinal) {
            this.ratingFinal = ratingFinal;
        }

        public String getTitleCn() {
            return titleCn;
        }

        public void setTitleCn(String titleCn) {
            this.titleCn = titleCn;
        }

        public String getTitleEn() {
            return titleEn;
        }

        public void setTitleEn(String titleEn) {
            this.titleEn = titleEn;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getWantedCount() {
            return wantedCount;
        }

        public void setWantedCount(int wantedCount) {
            this.wantedCount = wantedCount;
        }

        public static class NearestShowtimeBean {
            /**
             * isTicket : true
             * nearestCinemaCount : 142
             * nearestShowDay : 1517644800
             * nearestShowtimeCount : 595
             */

            private boolean isTicket;
            private int nearestCinemaCount;
            private int nearestShowDay;
            private int nearestShowtimeCount;

            public boolean isIsTicket() {
                return isTicket;
            }

            public void setIsTicket(boolean isTicket) {
                this.isTicket = isTicket;
            }

            public int getNearestCinemaCount() {
                return nearestCinemaCount;
            }

            public void setNearestCinemaCount(int nearestCinemaCount) {
                this.nearestCinemaCount = nearestCinemaCount;
            }

            public int getNearestShowDay() {
                return nearestShowDay;
            }

            public void setNearestShowDay(int nearestShowDay) {
                this.nearestShowDay = nearestShowDay;
            }

            public int getNearestShowtimeCount() {
                return nearestShowtimeCount;
            }

            public void setNearestShowtimeCount(int nearestShowtimeCount) {
                this.nearestShowtimeCount = nearestShowtimeCount;
            }
        }
    }
}

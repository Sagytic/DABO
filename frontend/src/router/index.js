import Vue from "vue";
import VueRouter from "vue-router";

// Views
const landing = () => import(/* webpackChunkName: "landing" */ "@/views/landing/landingPage.vue");
const Home = () => import(/* webpackChunkName: "home" */ "@/views/mainPage.vue");
const badge = () => import(/* webpackChunkName: "badge" */ "@/views/badge/badgeMain.vue");
const daboWallet = () => import(/* webpackChunkName: "daboWallet" */ "@/views/daboWallet/daboWalletMain.vue");
const donationBoard = () => import(/* webpackChunkName: "donationBoard" */ "@/views/donationBoard/donationBoardPage.vue");
const reservation = () => import(/* webpackChunkName: "reservation" */ "@/views/reservation/reservationMain.vue");
const bloodCard = () => import(/* webpackChunkName: "bloodCard" */ "@/views/bloodCard/bloodCard.vue");
const user = () => import(/* webpackChunkName: "user" */ "@/views/user/userPage.vue");
const myDabo = () => import(/* webpackChunkName: "myDabo" */ "@/views/user/myDabo.vue");
const chargeDabo = () => import(/* webpackChunkName: "chargeDabo" */ "@/views/daboWallet/chargeDabo.vue");
const payDabo = () => import(/* webpackChunkName: "payDabo" */ "@/views/daboWallet/payDabo.vue");
const chargeConfirm = () => import(/* webpackChunkName: "chargeConfirm" */ "@/views/daboWallet/chargeConfirm.vue");
const exBlockChain = () => import(/* webpackChunkName: "exBlockChain" */ "@/views/exBlockChain.vue");

// Components - Donation Board
const ListBoard = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardList.vue");
const ListItem = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardListItem.vue");
const CreateBoard = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardCreate.vue");
const UpdateBoard = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardUpdate.vue");
const DetailBoard = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationBoardDetail.vue");
const MyDonation = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/bloodCardDonation.vue");
const DonationConfirm = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/donationConfirm.vue");
const DaboDonation = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/daboDonation.vue");
const DaboConfirm = () => import(/* webpackChunkName: "donationBoard" */ "@/components/campaign/daboConfirm.vue");

// Components - Reservation
const BloodHouseList = () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/bloodHouseList.vue");
const NowReservation = () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/nowReservation.vue");
const ReservationHistory = () => import(/* webpackChunkName: "reservation" */ "@/components/reservation/reservationHistory.vue");

// Components - Blood Card
const bloodcardList = () => import(/* webpackChunkName: "bloodCard" */ "@/components/bloodcard/bloodcardList.vue");
const bloodcardCreate = () => import(/* webpackChunkName: "bloodCard" */ "@/components/bloodcard/bloodcardCreate.vue");

// Components - User
const Login = () => import(/* webpackChunkName: "user" */ "@/components/user/loginPage.vue");
const Signup = () => import(/* webpackChunkName: "user" */ "@/components/user/signUp.vue");
const infoChange = () => import(/* webpackChunkName: "user" */ "@/components/user/infoChange.vue");
const Ranking = () => import(/* webpackChunkName: "user" */ "@/components/user/rankingDetail.vue");
const Findpassword = () => import(/* webpackChunkName: "user" */ "@/components/user/findPassword.vue");

// Components - Wallet
const testDabo = () => import(/* webpackChunkName: "wallet" */ "@/components/wallet/testDabo.vue");

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "landing",
    component: landing,
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
  {
    path: "/user",
    name: "user",
    component: user,
    children: [
      {
        path: "login",
        name: "login",
        component: Login,
      },
      {
        path: "signup",
        name: "signup",
        component: Signup,
      },
      {
        path: "findpassword",
        name: "findpassword",
        component: Findpassword,
      },
      {
        path: "infochange",
        name: "infoChange",
        component: infoChange,
      },
      {
        path: "ranking",
        name: "ranking",
        component: Ranking,
      },
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: reservation,
    children: [
      {
        path: "bloodHouseList",
        name: "bloodHouseList",
        component: BloodHouseList,
      },
      {
        path: "nowReservation",
        name: "nowReservation",
        component: NowReservation,
      },
      {
        path: "reservationHistory",
        name: "reservationHistory",
        component: ReservationHistory,
      },
    ],
  },
  {
    path: "/donationBoard",
    name: "donationBoard",
    component: donationBoard,
    children: [
      {
        path: "listBoard",
        name: "listBoard",
        component: ListBoard,
      },
      {
        path: "listItem",
        name: "listItem",
        component: ListItem,
      },
      {
        path: "createBoard",
        name: "createBoard",
        component: CreateBoard,
      },
      {
        path: "updateBoard",
        name: "updateBoard",
        component: UpdateBoard,
      },
      {
        path: "detailBoard/:campaignId",
        name: "detailBoard",
        component: DetailBoard,
      },
      {
        path: "myDonation",
        name: "myDonation",
        component: MyDonation,
      },
      {
        path: "donationConfirm",
        name: "donationConfirm",
        component: DonationConfirm,
      },
      {
        path: "daboDonation",
        name: "daboDonation",
        component: DaboDonation,
      },
      {
        path: "daboConfirm",
        name: "daboConfirm",
        component: DaboConfirm,
      },
    ],
  },
  {
    path: "/dabowallet",
    name: "daboWallet",
    component: daboWallet,
    // children: [
    //   {
    //     path: "/chargedabo",
    //     name: "chargedabo",
    //     component: chargeDabo,
    //   },
    // ]
  },
  {
    path: "/testDabo",
    name: "testDabo",
    component: testDabo,
  },
  {
    path: "/dabowallet/chargedabo",
    name: "chargedabo",
    component: chargeDabo,
  },
  {
    path: "/dabowallet/paydabo",
    name: "paydabo",
    component: payDabo,
  },
  {
    path: "/dabowallet/chargeconfirm",
    name: "chargeconfirm",
    component: chargeConfirm,
  },
  {
    path: "/bloodcard",
    name: "bloodCard",
    component: bloodCard,
    children: [
      {
        path: "list",
        name: "bloodcardList",
        component: bloodcardList,
      },
      {
        path: "create",
        name: "bloodcardCreate",
        component: bloodcardCreate,
      },
    ],
  },
  {
    path: "/badge",
    name: "badge",
    component: badge,
  },
  {
    path: "/mydabo",
    name: "myDabo",
    component: myDabo,
  },
  {
    name: "exBlockChain",
    path: "/exBlockChain",
    component: exBlockChain,
    children: [
      {
        name: "exBlockChain.dashboard",
        path: "dashboard",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/Dashboard.vue"),
      },
      {
        name: "exBlockChain.block",
        path: "blocks",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/BlockListView.vue"),
      },
      {
        name: "exBlockChain.block.detail",
        path: "block/:blockNumber",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/BlockDetail.vue"),
      },
      {
        name: "exBlockChain.tx",
        path: "txes",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/TxListView.vue"),
      },
      {
        name: "exBlockChain.tx.detail",
        path: "tx/:hash",
        component: () => import(/* webpackChunkName: "exBlockChain" */ "@/components/explorer/TxDetail.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

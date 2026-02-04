import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);

// Lazy Load Components
const landing = () => import("@/views/landing/landingPage.vue");
const Home = () => import("@/views/mainPage.vue");
const badge = () => import("@/views/badge/badgeMain.vue");

const daboWallet = () => import("@/views/daboWallet/daboWalletMain.vue");

const donationBoard = () => import("@/views/donationBoard/donationBoardPage.vue");
const ListBoard = () => import("@/components/campaign/donationBoardList.vue");
const ListItem = () => import("@/components/campaign/donationBoardListItem.vue");
const CreateBoard = () => import("@/components/campaign/donationBoardCreate.vue");
const UpdateBoard = () => import("@/components/campaign/donationBoardUpdate.vue");
const DetailBoard = () => import("@/components/campaign/donationBoardDetail.vue");
const MyDonation = () => import("@/components/campaign/bloodCardDonation.vue");
const DonationConfirm = () => import("@/components/campaign/donationConfirm.vue");
const DaboDonation = () => import("@/components/campaign/daboDonation.vue");
const DaboConfirm = () => import("@/components/campaign/daboConfirm.vue");

const reservation = () => import("@/views/reservation/reservationMain.vue");
const BloodHouseList = () => import("@/components/reservation/bloodHouseList.vue");
const NowReservation = () => import("@/components/reservation/nowReservation.vue");
const ReservationHistory = () => import("@/components/reservation/reservationHistory.vue");

const bloodCard = () => import("@/views/bloodCard/bloodCard.vue");
const bloodcardList = () => import("@/components/bloodcard/bloodcardList.vue");
const bloodcardCreate = () => import("@/components/bloodcard/bloodcardCreate.vue");

const user = () => import("@/views/user/userPage.vue");
const Login = () => import("@/components/user/loginPage.vue");
const Signup = () => import("@/components/user/signUp.vue");
const infoChange = () => import("@/components/user/infoChange.vue");
const Ranking = () => import("@/components/user/rankingDetail.vue");
const myDabo = () => import("@/views/user/myDabo.vue");
const chargeDabo = () => import("@/views/daboWallet/chargeDabo.vue");
const payDabo = () => import("@/views/daboWallet/payDabo.vue");
const chargeConfirm = () => import("@/views/daboWallet/chargeConfirm.vue");

const Findpassword = () => import("@/components/user/findPassword.vue");

const exBlockChain = () => import("@/views/exBlockChain.vue");
const testDabo = () => import("@/components/wallet/testDabo.vue");
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
        component: () => import("@/components/explorer/Dashboard.vue"),
      },
      {
        name: "exBlockChain.block",
        path: "blocks",
        component: () => import("@/components/explorer/BlockListView.vue"),
      },
      {
        name: "exBlockChain.block.detail",
        path: "block/:blockNumber",
        component: () => import("@/components/explorer/BlockDetail.vue"),
      },
      {
        name: "exBlockChain.tx",
        path: "txes",
        component: () => import("@/components/explorer/TxListView.vue"),
      },
      {
        name: "exBlockChain.tx.detail",
        path: "tx/:hash",
        component: () => import("@/components/explorer/TxDetail.vue"),
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

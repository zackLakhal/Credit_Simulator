<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>Simulation de crédit</title>

    <link
      href="assets/plugins/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- You can change the theme colors from here -->
    <link href="css/colors/red.css" id="theme" rel="stylesheet" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
      .card-body {
        flex: 1 1 auto;
        padding: 1.25rem;
      }

      .card {
        word-wrap: break-word;
      }
    </style>
  </head>

  <body class="fix-header fix-sidebar card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
      <svg class="circular" viewBox="25 25 50 50">
        <circle
          class="path"
          cx="50"
          cy="50"
          r="20"
          fill="none"
          stroke-width="2"
          stroke-miterlimit="10"
        />
      </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
      <!-- ============================================================== -->
      <!-- Topbar header - style you can find in pages.scss -->
      <!-- ============================================================== -->
      <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
          <!-- ============================================================== -->
          <!-- Logo -->
          <!-- ============================================================== -->
          <div class="navbar-header">
            <a class="navbar-brand" href="Annuite.jsp">
              <!-- Logo icon -->
              <b>
                <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->

                <!-- Light Logo icon -->
                <img
                  src="assets/images/logo-light-icon.png"
                  alt="homepage"
                  class="light-logo"
                />
              </b>
              <!--End Logo icon -->
              <span style="font-weight: bold; color: white">IAO-Crédit</span>
              <!-- Logo text -->
              <span>
                <!-- Light Logo text -->
              </span>
            </a>
          </div>
          <!-- ============================================================== -->
          <!-- End Logo -->
          <!-- ============================================================== -->
          <div class="navbar-collapse">
            <!-- ============================================================== -->
            <!-- toggle and nav items -->
            <!-- ============================================================== -->
            <ul class="navbar-nav mr-auto mt-md-0">
              <!-- This is  -->
              <li class="nav-item">
                <a
                  class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark"
                  href="javascript:void(0)"
                  ><i class="mdi mdi-menu"></i
                ></a>
              </li>
              <!-- ============================================================== -->
              <!-- Search -->
              <!-- ============================================================== -->
            </ul>
            <!-- ============================================================== -->
            <!-- User profile and search -->
            <!-- ============================================================== -->
            <ul class="navbar-nav my-lg-0">
              <!-- ============================================================== -->
              <!-- Profile -->
              <!-- ============================================================== -->
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle text-muted waves-effect waves-dark"
                  href=""
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  <% if (session.getAttribute("emailClient") != null) { %>
                  <button
                    class="btn btn-rounded btn-warning"
                    type="button"
                    style="font-weight: bold"
                  >
                    ${prenomClient} ${nomClient}
                  </button>
                  <% } else { %>
                  <button
                    class="btn btn-rounded btn-warning"
                    type="button"
                    style="font-weight: bold"
                  >
                    Besoin d'un compte ?
                  </button>
                  <% } %>
                </a>
                <div class="dropdown-menu dropdown-menu-right scale-up">
                  <ul class="dropdown-user">
                    <% if (session.getAttribute("emailClient") != null) { %>
                    <li>
                      <div class="dw-user-box">
                        <div class="u-text">
                          <h4>Email : ${emailClient}</h4>
                          <br />
                          <h4>Tel : ${phoneClient}</h4>
                          <br />
                          <p>${adresseClient}</p>
                          <p class="text-muted">${villeClient}</p>
                        </div>
                      </div>
                    </li>
                    <li role="separator" class="divider"></li>
                    <li>
                      <a href="${pageContext.request.contextPath}/compte"
                        ><i class="ti-wallet"></i> Mes crédits</a
                      >
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/logout"
                        ><i class="fa fa-power-off"></i> Se déconnecter</a
                      >
                    </li>
                    <% } else { %>
                    <li>
                      <a href="#" data-toggle="modal" data-target="#LoginModal"
                        ><i class="ti-user"></i> Se connecter</a
                      >
                    </li>
                    <li>
                      <a
                        href="#"
                        data-toggle="modal"
                        data-target="#RegisterModal"
                        ><i class="fa fa-plus"></i> S'inscrire</a
                      >
                    </li>
                    <% } %>
                  </ul>
                </div>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Login modal -->
      <div
        id="LoginModal"
        class="modal fade"
        tabindex="-1"
        role="dialog"
        aria-labelledby="myModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">Se connecter</h4>
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                aria-hidden="true"
              >
                ×
              </button>
            </div>
            <div class="modal-body">
              <form
                class="form p-t-20"
                id="formLogin"
                method="POST"
                action="${pageContext.request.contextPath}/login"
              >
                <div class="form-group">
                  <label for="email_login">Email :</label>
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i class="fa fa-user-o"></i>
                    </div>
                    <input
                      type="email"
                      class="form-control"
                      id="email_login"
                      placeholder="email"
                      name="email_login"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password_login">Mot de passe :</label>
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i class="fa fa-hashtag"></i>
                    </div>
                    <input
                      type="password"
                      class="form-control"
                      id="password_login"
                      placeholder="mot de passe"
                      name="password_login"
                      required
                    />
                  </div>
                </div>

                <input
                  type="hidden"
                  name="viewid_login"
                  id="viewid_login"
                  value="Annuite.jsp"
                />
                <button
                  type="submit"
                  class="btn btn-success waves-effect waves-light m-r-10"
                >
                  se connecter
                </button>
              </form>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>

      <!-- Register modal -->
      <div
        id="RegisterModal"
        class="modal fade"
        tabindex="-1"
        role="dialog"
        aria-labelledby="myModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">S'inscrire</h4>
              <button
                type="button"
                class="close"
                data-dismiss="modal"
                aria-hidden="true"
              >
                ×
              </button>
            </div>
            <div class="modal-body">
              <form
                class="form p-t-20"
                id="formLogin"
                method="POST"
                action="${pageContext.request.contextPath}/signUp"
              >
                <div class="form-group">
                  <label for="nom_register">Nom :</label>
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      id="nom_register"
                      placeholder="Nom"
                      name="nom_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="prenom_register">Prénom :</label>
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      id="prenom_register"
                      placeholder="Prénom"
                      name="prenom_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="email_register">Email :</label>
                  <div class="input-group">
                    <input
                      type="email"
                      class="form-control"
                      id="email_register"
                      placeholder="email"
                      name="email_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password_register">Mot de passe :</label>
                  <div class="input-group">
                    <input
                      type="password"
                      class="form-control"
                      id="password_register"
                      placeholder="mot de passe"
                      name="password_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="adress_register">Adress :</label>
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      id="adress_register"
                      placeholder="Adress"
                      name="adress_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="tel_register">N° de téléphone :</label>
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      id="tel_register"
                      placeholder="tel"
                      name="tel_register"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="ville_register">Ville :</label>
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      id="ville_register"
                      placeholder="ville"
                      name="ville_register"
                      required
                    />
                  </div>
                </div>

                <input
                  type="hidden"
                  name="viewid_register"
                  id="viewid_register"
                  value="Annuite.jsp"
                />
                <button
                  type="submit"
                  class="btn btn-success waves-effect waves-light m-r-10"
                >
                  s'inscrire
                </button>
              </form>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>

      <!-- ============================================================== -->
      <!-- End Topbar header -->
      <!-- ============================================================== -->
      <!-- ============================================================== -->
      <!-- Left Sidebar - style you can find in sidebar.scss  -->
      <!-- ============================================================== -->
      <aside class="left-sidebar">
        <!-- Sidebar scroll-->
        <div class="scroll-sidebar">
          <!-- Sidebar navigation-->
          <nav class="sidebar-nav">
            <ul id="sidebarnav">
              <li>
                <a
                  class="waves-effect waves-dark"
                  href="Annuite.jsp"
                  aria-expanded="false"
                  ><i class="fa fa-money"></i
                  ><span class="hide-menu">Calcule Annuitée</span></a
                >
              </li>
              <li>
                <a
                  class="waves-effect waves-dark"
                  href="Capital.jsp"
                  aria-expanded="false"
                  ><i class="fa fa-percent"></i
                  ><span class="hide-menu">Calcule Capital</span></a
                >
              </li>
              <li>
                <a
                  class="waves-effect waves-dark"
                  href="Duree.jsp"
                  aria-expanded="false"
                  ><i class="fa fa-clock-o"></i
                  ><span class="hide-menu">Calcule Durée</span></a
                >
              </li>
              <% if (session.getAttribute("emailClient") != null) { %>
              <li>
                <a
                  class="waves-effect waves-dark"
                  href="${pageContext.request.contextPath}/compte"
                  aria-expanded="false"
                  ><i class="fa fa-credit-card"></i
                  ><span class="hide-menu">Mes crédits</span></a
                >
              </li>
              <% } %>
            </ul>
          </nav>
          <!-- End Sidebar navigation -->
        </div>
        <!-- End Sidebar scroll-->
        <!-- Bottom points-->
        <% if (session.getAttribute("emailClient") != null) { %>
        <div class="sidebar-footer">
          <!-- item-->
          <a
            href="${pageContext.request.contextPath}/logout"
            class="link"
            data-toggle="tooltip"
            title="Logout"
            style="margin-left: 35%"
            ><i class="mdi mdi-power"></i
          ></a>
        </div>
        <% } %>
        <!-- End Bottom points-->
      </aside>
      <!-- ============================================================== -->
      <!-- End Left Sidebar - style you can find in sidebar.scss  -->
      <!-- ============================================================== -->
      <!-- ============================================================== -->
      <!-- Page wrapper  -->
      <!-- ============================================================== -->
      <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
          <!-- ============================================================== -->
          <!-- Bread crumb and right sidebar toggle -->
          <!-- ============================================================== -->
          <div class="row page-titles">
            <div class="col-md-5 col-8 align-self-center">
              <h3 class="text-themecolor m-b-0 m-t-0">Calcule du capital</h3>
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="javascript:void(0)">Home</a>
                </li>
                <li class="breadcrumb-item active">Calcule du capital</li>
              </ol>
            </div>
          </div>
          <!-- ============================================================== -->
          <!-- End Bread crumb and right sidebar toggle -->
          <!-- ============================================================== -->
          <% if (session.getAttribute("error_login") != null &&
          (boolean)session.getAttribute("error_login")) { %>
          <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
              <div class="card text-center">
                <div class="card-body">
                  <h2 class="card-title" style="color: red">
                    Erreur : email ou mot de passe incorrect
                  </h2>
                </div>
              </div>
            </div>
            <div class="col-md-3"></div>
          </div>
          <% } else { %> <% } %> <% if (session.getAttribute("error_register")
          != null && (boolean) session.getAttribute("error_register")) { %>
          <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
              <div class="card text-center">
                <div class="card-body">
                  <h2 class="card-title" style="color: red">
                    Erreur : Set Email exist déja
                  </h2>
                </div>
              </div>
            </div>
            <div class="col-md-3"></div>
          </div>
          <% } else { %> <% } %>

          <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
              <div class="card card-outline-danger text-center">
                <div class="card-header">
                  <h4 class="m-b-0 text-white">Capital</h4>
                </div>
                <div class="card-body">
                  <h3 class="card-title">
                    Résultat : <% if (session.getAttribute("capitalrep") != null)
                    { %> ${capitalrep} <% } else { %> pas de résultat <% } %>
                  </h3>
                  <br />

                  <h3 class="card-title">
                    Etat d'enregistrement : <% if
                    (session.getAttribute("capitalrep") != null) { %> <% if
                    ((boolean) session.getAttribute("addBDrep")) { %>
                    <span style="color: green">Enregistré</span>
                    <% } else { %>
                    <span style="color: red">Non Enregistré</span>
                    <% } %> <% } else { %> <% } %>
                  </h3>
                </div>
              </div>
            </div>
            <div class="col-md-3"></div>
          </div>

          <!-- ============================================================== -->
          <!-- Start Page Content -->
          <!-- ============================================================== -->
          <div class="row">
            <div class="col-lg-12">
              <div class="card card-outline-info">
                <div class="card-header">
                  <h4 class="m-b-0 text-white">
                    formulaire de calcule du capital
                  </h4>
                </div>
                <div class="card-body">
                  <form
                    class="form p-t-20"
                    id="formCapital"
                    method="POST"
                    action="${pageContext.request.contextPath}/capital"
                  >
                    <div class="form-group">
                      <label for="Annuitee">Entrez votre Annuitée :</label>
                      <div class="input-group">
                        <div class="input-group-addon">
                          <i class="fa fa-money"></i>
                        </div>
                        <% if (session.getAttribute("anuiterep") != null) { %>
                        <input
                          type="number"
                          name="Annuitee"
                          class="form-control"
                          id="Annuitee"
                          placeholder="Annuitée"
                          value="${anuiterep}"
                          
                          min="1"
                          required
                        />
                        <% } else { %>
                        <input
                          type="number"
                          name="Annuitee"
                          class="form-control"
                          id="Annuitee"
                          placeholder="Annuitée"
                          min="1"
                          required
                        />

                        <% } %>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="Duree">Précisez une durée :</label>
                      <div class="input-group">
                        <div class="input-group-addon">
                          <i class="fa fa-clock-o"></i>
                        </div>
                        <% if (session.getAttribute("dureerep") != null) { %>
                        <input
                          type="number"
                          name="Duree"
                          class="form-control"
                          id="Duree"
                          placeholder="Durée"
                          value="${dureerep}"
                          
                          min="1"
                          required
                        />
                        <% } else { %>
                        <input
                          type="number"
                          name="Duree"
                          class="form-control"
                          id="Duree"
                          placeholder="Durée"
                          min="1"
                          required
                        />

                        <% } %>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="Taux">Spécifiez un taux en (%) :</label>
                      <div class="input-group">
                        <div class="input-group-addon">
                          <i class="fa fa-percent"></i>
                        </div>
                        <% if (session.getAttribute("tauxrep") != null) { %>
                        <input
                          type="number"
                          name="Taux"
                          class="form-control"
                          id="Taux"
                          placeholder="taux en %"
                          value="${tauxrep}"
                          
                          min="1"
                          required
                        />
                        <% } else { %>
                        <input
                          type="number"
                          name="Taux"
                          class="form-control"
                          id="Taux"
                          placeholder="taux en %"
                          min="1"
                          required
                        />

                        <% } %>
                      </div>
                    </div>
                    <% if (session.getAttribute("emailClient") != null) { %>
                    <div class="form-group">
                      <input
                        type="radio"
                        id="non_addBD"
                        name="addBD"
                        value="non enregistré"
                        checked
                      />
                      <label for="non_addBD">calculer seulement</label>
                      <input
                        type="radio"
                        id="addBD"
                        name="addBD"
                        value="enregistré"
                      />
                      <label for="addBD">calculer et sauvgarder</label>
                    </div>
                    <% } %>
                    <input
                      type="submit"
                      value="calculer"
                      class="btn btn-success"
                      name="sub"
                    />
                    <input
                      type="submit"
                      value="effacer"
                      class="btn btn-inverse"
                      name="sub"
                    />
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!-- ============================================================== -->
          <!-- End PAge Content -->
          <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Container fluid  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <footer class="footer">© 2020 IAO-Crédit by Zakaria Lakhal</footer>
        <!-- ============================================================== -->
        <!-- End footer -->
        <!-- ============================================================== -->
      </div>
      <!-- ============================================================== -->
      <!-- End Page wrapper  -->
      <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/plugins/bootstrap/js/tether.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="js/custom.min.js"></script>

    <script src="assets/plugins/sparkline/jquery.sparkline.min.js"></script>

    <script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
  </body>
</html>

(ns publisher.login
  (:require [goog.object :as g]
            [publisher.state :as state]))

(defn- login [event]
  (.preventDefault event)
  (let [;; Netlify (g/get js/window "netlify")
        default (.-default js/netlify)
        authenticator (default. #js {:site_id "2cbd2dcf-e533-41e4-bb0d-dd422e9c8561"})]
    ;; (js/debugger)
    (.authenticate authenticator
                   #js {:provider "github" :scope "repo"}
                   (fn [error data]
                     (if error
                       (swap! state/db
                              assoc
                              :message
                              (str "Error authenticating with github: " error))
                       (swap! state/db
                              assoc
                              :message
                              (str "Authenticated with github! Token: " (-> data js->clj (get "token")))))))))

(defn github []
  [:<>
   [:p (:message @state/db)]
   [:button {:on-click login} "Sign in with github"]])


  ;; <h1>GitHub Auth Demo:</h1>
  ;; <p><a href="#" id="login">Authenticate</a></p>
  ;; <p id="output"></p>
  ;; <script>
  ;;   const anchorTag = document.getElementById('login')
  ;;   const outputText = document.getElementById('output')

  ;;   anchorTag.addEventListener('click', (e) => {
  ;;     e.preventDefault()

  ;;     const authenticator = new netlify.default ({})

  ;;     authenticator.authenticate({provider:"github", scope: "user"}, (err, data) => {
  ;;       err ? outputText.innerText = "Error Authenticating with GitHub: " + err :
  ;;       outputText.innerText = "Authenticated with GitHub. Access Token: " + data.token
  ;;     })
  ;;   })

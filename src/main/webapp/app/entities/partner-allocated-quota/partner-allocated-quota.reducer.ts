import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IPartnerAllocatedQuota, defaultValue } from 'app/shared/model/partner-allocated-quota.model';

export const ACTION_TYPES = {
  FETCH_PARTNERALLOCATEDQUOTA_LIST: 'partnerAllocatedQuota/FETCH_PARTNERALLOCATEDQUOTA_LIST',
  FETCH_PARTNERALLOCATEDQUOTA: 'partnerAllocatedQuota/FETCH_PARTNERALLOCATEDQUOTA',
  CREATE_PARTNERALLOCATEDQUOTA: 'partnerAllocatedQuota/CREATE_PARTNERALLOCATEDQUOTA',
  UPDATE_PARTNERALLOCATEDQUOTA: 'partnerAllocatedQuota/UPDATE_PARTNERALLOCATEDQUOTA',
  DELETE_PARTNERALLOCATEDQUOTA: 'partnerAllocatedQuota/DELETE_PARTNERALLOCATEDQUOTA',
  RESET: 'partnerAllocatedQuota/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IPartnerAllocatedQuota>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type PartnerAllocatedQuotaState = Readonly<typeof initialState>;

// Reducer

export default (state: PartnerAllocatedQuotaState = initialState, action): PartnerAllocatedQuotaState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA_LIST):
    case REQUEST(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_PARTNERALLOCATEDQUOTA):
    case REQUEST(ACTION_TYPES.UPDATE_PARTNERALLOCATEDQUOTA):
    case REQUEST(ACTION_TYPES.DELETE_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA_LIST):
    case FAILURE(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA):
    case FAILURE(ACTION_TYPES.CREATE_PARTNERALLOCATEDQUOTA):
    case FAILURE(ACTION_TYPES.UPDATE_PARTNERALLOCATEDQUOTA):
    case FAILURE(ACTION_TYPES.DELETE_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_PARTNERALLOCATEDQUOTA):
    case SUCCESS(ACTION_TYPES.UPDATE_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_PARTNERALLOCATEDQUOTA):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/partner-allocated-quotas';

// Actions

export const getEntities: ICrudGetAllAction<IPartnerAllocatedQuota> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA_LIST,
  payload: axios.get<IPartnerAllocatedQuota>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IPartnerAllocatedQuota> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_PARTNERALLOCATEDQUOTA,
    payload: axios.get<IPartnerAllocatedQuota>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IPartnerAllocatedQuota> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_PARTNERALLOCATEDQUOTA,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IPartnerAllocatedQuota> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_PARTNERALLOCATEDQUOTA,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IPartnerAllocatedQuota> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_PARTNERALLOCATEDQUOTA,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
